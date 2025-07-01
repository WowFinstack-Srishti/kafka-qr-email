In ```kafka-qr-email/src/main/resources``` create application.yaml <br/>
Its path is ```kafka-qr-email/src/main/resources/application.yaml```

**Note: Here your app password is not your email password. Its the app password generated. Steps to generate your app password is given below.**

***application.yaml code:***
```yaml
server:
    port: 8085

spring:
    application:
        name: kafka-qr-email
    kafka:
        bootstrap-servers: localhost:9092
        producer:
            key-serializer: org.apache.kafka.common.serialization.StringSerializer
            value-serializer: org.apache.kafka.common.serialization.StringSerializer
        consumer:
            key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
            value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
            group-id: kafka_learn
            auto-offset-reset: earliest
    
    mail:
        host: smtp.gmail.com
        port: 587
        username: your-email@gmail.com
        password: your-app-password
        properties:
            mail:
                smtp:
                    auth: true
                    starttls:
                        enable: true
```

***⚠️ Important: Google will not show this app password again.***

***Step-by-step: View/Generate Gmail App Password:***
1. Go to Google Account Settings: https://myaccount.google.com/
2. Click “Security” in the left sidebar.
3. Scroll down to “Signing in to Google” section.
4. Ensure 2-Step Verification is ON. If not, you must enable it first.
5. Once 2-Step Verification is enabled, you’ll see an “App passwords” option just below it.
6. Click App passwords
7. You might have to log in again.
8. Under “Select app”, choose:
   -App: Mail
   -Device: Other (or pick a device name like “KafkaApp”)
9. Click Generate
10. Google will show you a 16-character password like: ```abcd efgh ijkl mnop```
11. Copy and paste this into your application.yaml
