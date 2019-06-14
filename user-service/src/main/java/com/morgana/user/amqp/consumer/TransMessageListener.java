package com.morgana.user.amqp.consumer;

import com.morgana.mq.listener.AbstractMessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
public class TransMessageListener extends AbstractMessageListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void receiveMessage(Message message) {
        logger.info(new String(message.getBody()));
    }
}