package com.wowfinstack.kafka_qr_email.service;

public interface EmailService {
    void sendQrGeneratedNotification(String to);
}
