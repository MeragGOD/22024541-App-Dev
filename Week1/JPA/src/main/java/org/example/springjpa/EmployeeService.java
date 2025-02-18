package org.example.springjpa;

import java.util.ArrayList;

public interface EmployeeService {
    ArrayList<Employee> findAllEmployee();
    Employee findAllEmployeeByID(long id);
    void addEmployee();
    void deleteAllData();
}
