package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

private final EmployeeService service;

public EmployeeController(EmployeeService service) {
this.service = service;
}

@PostMapping
public Employee addEmployee(@RequestBody Employee employee) {
return service.addEmployee(employee);
}

@GetMapping("/{id}")
public Employee getEmployee(@PathVariable Long id) {
return service.getEmployee(id);
}
}
