package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping("{employeeId}")
  public Employee findById(@PathVariable String employeeId) {
    return employeeService.findById(employeeId);
  }

  @GetMapping(params = "age")
  public List<Employee> findAgeAbove(@RequestParam int age) {
    return employeeService.findAgeAbove(age);
  }

  @PostMapping
  public Employee addEmployee(@RequestBody Employee employee) {
    return employeeService.add(employee);
  }

  @DeleteMapping("{employeeId}")
  public Employee deleteEmployee(@PathVariable String employeeId) {
    return employeeService.delete(employeeId);
  }

  @PutMapping("{employeeId}")
  public Employee updateEmployee(@RequestBody Employee employee, @PathVariable String employeeId) {
    return employeeService.update(employee, employeeId);
  }
}
