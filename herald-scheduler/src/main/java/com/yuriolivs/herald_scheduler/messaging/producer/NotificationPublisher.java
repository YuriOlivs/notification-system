package com.yuriolivs.herald_scheduler.messaging.producer;

import com.yuriolivs.notification.shared.domain.notification.NotificationMessage;
import com.yuriolivs.herald_scheduler.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publish(NotificationMessage send) {
        String routingKey = send.getChannel().name().toLowerCase();

        rabbitTemplate.convertAndSend(
            RabbitMqConfig.EXCHANGE,
            routingKey,
            send,
            msg -> {
            msg.getMessageProperties()
                    .setPriority(send.getPriority().value());

            return msg;
            }
        );
    }
}
