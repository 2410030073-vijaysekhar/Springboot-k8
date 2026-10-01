package com.example.demo.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
class EmployeeIntegrationTest {

@Autowired
private EmployeeRepository repository;

@Test
void testCompleteApplication() {

Employee employee =
new Employee("Suresh1234", "ECE");

Employee saved =
repository.save(employee);

assertThat(saved).isNotNull();
assertThat(saved.getId()).isNotNull();

Employee result =
repository.findById(saved.getId())
.orElse(null);

assertThat(result).isNotNull();
assertThat(result.getName())
.isEqualTo("Suresh1234");
}
}
