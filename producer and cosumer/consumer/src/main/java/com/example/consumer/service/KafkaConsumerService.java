package com.example.consumer.service;

import com.example.producer.model.User; // Import class User của Consumer
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "user-topic", groupId = "user-consumer-group")
    public void consume(User user) {
        logger.info("Consumer received a message!");
        logger.info(String.format("Consumed message: %s", user));
        System.out.println("Received User: " + user.getUsername() + " (" + user.getEmail() + ")");
    }
}