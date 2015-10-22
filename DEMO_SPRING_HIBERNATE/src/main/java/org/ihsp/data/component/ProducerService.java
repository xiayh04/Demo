package org.ihsp.data.component;

import javax.jms.Destination;

import org.ihsp.data.cache.common.IMPObjectMessage;


public interface ProducerService {

    public void sendMessage(Destination destination, String message);

    public void sendMessage(Destination destination, IMPObjectMessage message);

}
