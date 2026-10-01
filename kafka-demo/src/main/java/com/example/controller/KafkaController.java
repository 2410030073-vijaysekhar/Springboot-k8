package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.producer.KafkaProducerService;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaProducerService producer;

    public KafkaController(KafkaProducerService producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody Employee employee) {
        producer.send(employee);
        return "Message Published Successfully";
    }
}