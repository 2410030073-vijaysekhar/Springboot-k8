package com.example.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.model.Employee;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "Employee-topic";

    private final KafkaTemplate<String, Employee> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Employee employee) {
        kafkaTemplate.send(TOPIC, employee);
        System.out.println("Message Sent");
    }
}