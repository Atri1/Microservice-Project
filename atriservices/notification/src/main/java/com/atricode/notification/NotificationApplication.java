package com.atricode.notification;

import com.atricode.amqp.MessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages =
        { "com.atricode.notification",
        "com.atricode.amqp"}
)
@EnableEurekaClient
public class NotificationApplication {

    public static void main(String args[]) {
        SpringApplication.run(NotificationApplication.class, args);
    }


//    @Bean
//    CommandLineRunner commandLineRunner(
//            MessageProducer producer,
//            NotificationConfig notificationConfig
//    ) {
//        return args -> {
//            producer.publish(
//                    "foo",
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
}