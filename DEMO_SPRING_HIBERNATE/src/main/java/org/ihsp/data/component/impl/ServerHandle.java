package org.ihsp.data.component.impl;

import java.text.SimpleDateFormat;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandle extends IoHandlerAdapter {

    private static Logger log = LoggerFactory.getLogger(ServerHandle.class);

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        log.info("session created:" + session.getId());
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        log.info("session opened:" + session.getId());
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        log.info("session closed:" + session.getId());
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        log.info("IDLE seesions count: " + session.getIdleCount(status));
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {

        String msg = message.toString();
        msg = msg.trim();
        if (msg.trim().equalsIgnoreCase("quit")) {
            session.close(true);
            return;
        }
        System.out.println("Request From:" + session.getRemoteAddress());  
        //返给客户端的消息内容：服务器系统当前时间  
        session.write("Server Time: "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));  
//        Date date = new Date();
//        session.write(date.toString());
    }

}
