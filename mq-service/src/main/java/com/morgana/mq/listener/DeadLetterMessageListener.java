package com.morgana.mq.listener;

import com.morgana.mq.util.MQConstants;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeadLetterMessageListener implements ChannelAwareMessageListener {
    private Logger logger = LoggerFactory.getLogger(DeadLetterMessageListener.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Callback for processing a received Rabbit message.
     * <p>Implementors are supposed to process the given Message,
     * typically sending reply messages through the given Session.
     * @param message the received AMQP message (never <code>null</code>)
     * @param channel the underlying Rabbit Channel (never <code>null</code>)
     * @throws Exception Any.
     */
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        MessageProperties messageProperties = message.getMessageProperties();
        // 消息体
        String messageBody = new String(message.getBody());

        logger.warn("dead letter message：{} | tag：{}", messageBody, message.getMessageProperties().getDeliveryTag());

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        redisTemplate.opsForHash().delete(MQConstants.MQ_CONSUMER_RETRY_COUNT_KEY, messageProperties.getMessageId());
    }

}