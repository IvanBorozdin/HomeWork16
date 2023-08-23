package ru.skepro.homework17.service;

import ru.skepro.homework17.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int departmentIt);

 //   Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName );
    Employee find(String firstName,String lastName);

    Collection<Employee> findAll();
}
