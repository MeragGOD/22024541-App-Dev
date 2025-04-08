package com.example.producer.controller;

import com.example.producer.model.User;
import com.example.producer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/publish")
    public String publishUser(@RequestBody User user) {
        producerService.sendMessage(user);
        return "User published to Kafka successfully!";
    }
}