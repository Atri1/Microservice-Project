package com.atricode.notification;

import com.atricode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;
    @Autowired
    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    private final Logger log = LoggerFactory.getLogger(NotificationController.class);
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification... {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}