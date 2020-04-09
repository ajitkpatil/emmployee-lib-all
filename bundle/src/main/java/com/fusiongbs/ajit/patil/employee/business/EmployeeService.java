package com.fusiongbs.ajit.patil.employee.business;

import com.fusiongbs.ajit.patil.employee.business.domain.Employee;

public interface EmployeeService {

    public Employee createEmployee(String employeeId, String employeeName);
}
