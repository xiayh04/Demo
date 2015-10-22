package org.ihsp.data.component;

import javax.jms.Destination;

import org.ihsp.data.common.UnitTestBase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// @Ignore
public class ProducerServiceTest extends UnitTestBase {

    @Autowired
    ProducerService producerService;

    @Autowired
    @Qualifier("topicDestination")
    private Destination topicDestination;

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testSendMessage() {
        for (int i = 0; i < 2; i++) {
            producerService.sendMessage(topicDestination, "消息:" + i);
        }
        for (int i = 3; i < 5; i++) {
            producerService.sendMessage(null, "消息:" + i);
        }
    }

    
    @Ignore
    @Test
    public void testObjectMessage() {
        for (int i = 0; i < 10000; i++) {
            producerService.sendMessage(null, "消息:" + i);
        }
    }
}
