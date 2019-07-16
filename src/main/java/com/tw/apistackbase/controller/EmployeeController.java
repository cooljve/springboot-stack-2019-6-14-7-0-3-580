package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private EmployeeRepository repository = new EmployeeRepository();

  @GetMapping
  public List<Employee> findAll() {
    return repository.findAll();
  }

  @GetMapping("{employeeId}")
  public Employee findById(@PathVariable String employeeId) {
    return repository.findById(employeeId);
  }

  @GetMapping(params = "age")
  public List<Employee> findAgeAbove(@RequestParam int age) {
    return repository.findAgeAbove(age);
  }

  @PostMapping
  public Employee addEmployee(@RequestBody Employee employee) {
    return repository.add(employee);
  }

  @DeleteMapping("{employeeId}")
  public Employee deleteEmployee(@PathVariable String employeeId) {
    return repository.delete(employeeId);
  }

  @PutMapping("{employeeId}")
  public Employee updateEmployee(@RequestBody Employee employee, @PathVariable String employeeId) {
    return repository.update(employee, employeeId);
  }
}
