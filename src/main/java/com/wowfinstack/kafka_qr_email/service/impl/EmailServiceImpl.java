package com.wowfinstack.kafka_qr_email.service.impl;

import com.wowfinstack.kafka_qr_email.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @KafkaListener(topics = "email-notifications", groupId = "email-group")
    public void listen(String email) {
        sendQrGeneratedNotification(email);
    }

    @Override
    public void sendQrGeneratedNotification(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("QR Code Generated");
        message.setText("Your QR code has been successfully generated.");
        message.setFrom("no-reply@wowfinstack.com");
        mailSender.send(message);
    }
}
