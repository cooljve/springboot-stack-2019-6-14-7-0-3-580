package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeRepository {
  private static Map<String, Employee> map = new HashMap<>();

  static {
    map.put("1", new Employee("1", "Joi", 22, "female"));
    map.put("2", new Employee("2", "Bob", 22, "male"));
    map.put("3", new Employee("3", "Max", 22, "male"));
  }

  public List<Employee> findAll() {
    return new ArrayList<>(map.values());
  }

  public Employee findById(String employeeId) {
    return map.get(employeeId);
  }

  public Employee add(Employee employee) {
    String id = UUID.randomUUID().toString();
    employee.setId(id);
    map.put(id, employee);
    return employee;
  }

  public Employee delete(String employeeId) {
    return map.remove(employeeId);
  }

  public List<Employee> findByAge(int age) {
    return new ArrayList<>(map.values()).stream().filter(x -> x.getAge() > age).collect(Collectors.toList());
  }
}
