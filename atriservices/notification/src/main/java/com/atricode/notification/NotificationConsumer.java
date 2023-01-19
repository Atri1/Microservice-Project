package com.atricode.notification;

import com.atricode.clients.notification.NotificationRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Data
public class NotificationConsumer {

    private final NotificationService notificationService;
    @Autowired
    public NotificationConsumer(NotificationService notificationService){

        this.notificationService = notificationService;
    }
    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest){
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
