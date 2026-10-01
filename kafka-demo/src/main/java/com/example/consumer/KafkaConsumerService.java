package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.model.Employee;

@Service
public class KafkaConsumerService {

    @KafkaListener(
        topics = "Employee-topic",
        groupId = "my-group"
    )
    public void consume(Employee employee) {

        System.out.println("-----------------------");
        System.out.println("Received Employee");
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getSalary());
        System.out.println("-----------------------");
    }
}