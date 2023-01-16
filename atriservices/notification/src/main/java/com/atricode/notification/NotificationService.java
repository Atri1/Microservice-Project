package com.atricode.notification;

import com.atricode.clients.notification.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    @Autowired
    NotificationService(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    public void send(NotificationRequest notificationRequest){
        notificationRepository.save(new Notification(
                notificationRequest.getToCustomerId(),
                notificationRequest.getToCustomerEmail(),
                "Atri",
                notificationRequest.getMessage(),
                LocalDateTime.now()));
    }
}
