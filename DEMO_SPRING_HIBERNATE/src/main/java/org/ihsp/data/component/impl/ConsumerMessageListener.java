package org.ihsp.data.component.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ihsp.data.cache.common.IMPObjectMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ConsumerMessageListener implements MessageListener {
    Log log = LogFactory.getLog(ConsumerMessageListener.class);
    @Value("${activemq.subscript.name}")
    private String subscriptName;

    @Value("${defaultDS}")
    private String defaultDS;

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage textMsg = (TextMessage) message;
                String publisherName = textMsg.getStringProperty("publisherName");
                if (StringUtils.equalsIgnoreCase(publisherName, subscriptName)) {
                    log.info("received your own message. ignor.source:" + publisherName);
                    return;
                }
                log.info("接收到一个纯文本消息。");
                log.info("消息内容是：" + textMsg.getText());
                return;
            } else if (message instanceof ObjectMessage) {
                log.info("received an object message.");
                ObjectMessage msg = (ObjectMessage) message;
                String publisherName = msg.getStringProperty("publisherName");
                String targetDB = msg.getStringProperty("targetDB");
                // 一个服务软件可以动态映射到多个数据库。如果情况是：当前server01用的是DB2，并发送了一个消息。
                // 这个时候，server01,02,03都会接受到消息。实际情况是server02，对应的DB2，无需更新消息。其他都需要。
                if (StringUtils.equalsIgnoreCase(publisherName, subscriptName)) {
                    log.info("received a message send by current server: " + publisherName);
                    // return;
                }
                log.info("received a message its targetDB is: " + targetDB + ", default data source is: " + defaultDS);

                if (StringUtils.equalsIgnoreCase(targetDB, defaultDS)) {
                    log.info("received a message its targetDB is the same as the current default. ignore: " + targetDB);
                    // return;
                }

                IMPObjectMessage impMessage = (IMPObjectMessage) msg.getObject();
                if (impMessage != null && impMessage.getType() != null) {
                   /* switch (impMessage.getType()) {
                    // application/project
                        case ObjectMessageConstant.SAV_APPLICATION_OBJ_LIST:
                            log.info("received an object message:" + ObjectMessageConstant.SAV_APPLICATION_OBJ_LIST);
                            List<Application> applications = (List<Application>) impMessage.getObject();
                            applicationService.saveOrUpdate(applications);
                            break;
                       


                        default:
                            log.info("can not find the matched ObjectMessageConstant.");
                            break;

                    }*/

                }

            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
