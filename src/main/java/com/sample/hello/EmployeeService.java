package com.sample.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findOneById(Integer id) {
        return employeeRepository.findOne(id);
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }
}
