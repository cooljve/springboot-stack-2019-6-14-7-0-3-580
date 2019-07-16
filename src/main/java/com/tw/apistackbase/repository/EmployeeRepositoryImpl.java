package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
  private static Map<String, Employee> map = new HashMap<>();

  static {
    map.put("1", new Employee("1", "Joi", 22, "female"));
    map.put("2", new Employee("2", "Bob", 22, "male"));
    map.put("3", new Employee("3", "Max", 22, "male"));
  }

  @Override
  public List<Employee> findAll() {
    return new ArrayList<>(map.values());
  }

  @Override
  public Employee findById(String employeeId) {
    return map.get(employeeId);
  }

  @Override
  public Employee add(Employee employee) {
    String id = UUID.randomUUID().toString();
    employee.setId(id);
    map.put(id, employee);
    return employee;
  }

  @Override
  public Employee delete(String employeeId) {
    return map.remove(employeeId);
  }

  @Override
  public List<Employee> findAgeAbove(int age) {
    return new ArrayList<>(map.values()).stream().filter(x -> x.getAge() > age).collect(Collectors.toList());
  }

  @Override
  public Employee update(Employee employee, String employeeId) {
    if (map.containsValue(employeeId)) {
      map.replace(employeeId, employee);
    } else {
      employee.setId(employeeId);
      map.put(employeeId, employee);
    }
    return employee;
  }
}
