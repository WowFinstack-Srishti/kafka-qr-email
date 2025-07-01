package com.wowfinstack.kafka_qr_email.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthCheckController {
    @GetMapping
    public String status() {
        return "Kafka Email Service is up!";
    }
}
