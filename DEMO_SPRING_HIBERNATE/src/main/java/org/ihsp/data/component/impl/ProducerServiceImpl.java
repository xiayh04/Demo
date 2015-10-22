package org.ihsp.data.component.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ihsp.data.cache.common.IMPObjectMessage;
import org.ihsp.data.component.ProducerService;
import org.ihsp.data.utils.DataSourceSwitcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;


@Component("producerServiceImpl")
public class ProducerServiceImpl implements ProducerService {
    Log log = LogFactory.getLog(ProducerServiceImpl.class);

    @Value("${activemq.subscript.name}")
    private String subscriptName;
    @Autowired
    @Qualifier("jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("topicDestination")
    private Destination topicDestination;

    @Override
    public void sendMessage(Destination destination, final String message) {
        if (destination == null) {
            destination = topicDestination;
        }
        log.info("---------------生产者发了一个消息：" + message);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage msg = session.createTextMessage(message);
                msg.setStringProperty("publisherName", subscriptName);
                msg.setStringProperty("targetDB", DataSourceSwitcher.getDataSource());
                return msg;
            }
        });
    }

    @Override
    public void sendMessage(Destination destination, final IMPObjectMessage message) {
        if (destination == null) {
            destination = topicDestination;
        }
        log.info("---------------生产者发了一个消息：" + message);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage msg = session.createObjectMessage();
                msg.setStringProperty("publisherName", subscriptName);
                msg.setStringProperty("targetDB", DataSourceSwitcher.getDataSource());
                msg.setObject(message);
                return msg;
            }
        });
    }


}
