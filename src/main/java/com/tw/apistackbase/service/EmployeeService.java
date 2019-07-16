package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public Employee findById(String employeeId) {
    return employeeRepository.findById(employeeId);
  }

  public Employee add(Employee employee) {
    return employeeRepository.add(employee);
  }

  public Employee delete(String employeeId) {
    return employeeRepository.delete(employeeId);
  }

  public List<Employee> findAgeAbove(int age) {
    return employeeRepository.findAgeAbove(age);
  }

  public Employee update(Employee employee, String employeeId) {
    return employeeRepository.update(employee, employeeId);
  }
}
