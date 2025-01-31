package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private EmployeeService service;

  @Test
  public void should_return_employee_find_by_id()throws Exception {
    Employee employee = new Employee("1", "Joi", 22, "female");
    when(service.findById(anyString())).thenReturn(employee);

    ResultActions result = mvc.perform(get("/employees/{employeeId}",employee.getId()));

    result.andExpect(status().isOk())
        .andExpect(jsonPath("$.name",is("Joi")))
        .andExpect(jsonPath("$.age",is(22)))
        .andExpect(jsonPath("$.gender",is("female")));
  }

  @Test
  public void should_return_employees_find_all()throws Exception {
    Employee employee = new Employee("1", "Joi", 22, "female");
    when(service.findAll()).thenReturn(Arrays.asList(employee));

    ResultActions result = mvc.perform(get("/employees"));

    result.andExpect(status().isOk());
  }

}