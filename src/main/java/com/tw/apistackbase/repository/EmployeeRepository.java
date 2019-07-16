package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface EmployeeRepository {
  List<Employee> findAll();

  Employee findById(String employeeId);

  Employee add(Employee employee);

  Employee delete(String employeeId);

  List<Employee> findAgeAbove(int age);

  Employee update(Employee employee, String employeeId);
}
