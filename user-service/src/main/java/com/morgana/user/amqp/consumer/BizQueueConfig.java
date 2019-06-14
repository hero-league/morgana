package com.morgana.user.amqp.consumer;//package com.coolmq.amqp.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BizQueueConfig {

    @Bean
    public DirectExchange transExchange() {
        return new DirectExchange("user.exchange");
    }

    @Bean
    public Queue transQueue() {
        return new Queue("user.queue",true,false,false);
    }

    @Bean
    public Binding transBinding() {
        return BindingBuilder.bind(transQueue()).to(transExchange())
                .with("user.key");
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory,
                                                                         TransMessageListener transMessageListener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(transQueue());
        container.setExposeListenerChannel(true);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(transMessageListener);
        return container;
    }
}
