package ru.skepro.homework17.service;

import org.springframework.stereotype.Service;
import ru.skepro.homework17.exception.EmployeeAlreadyAddedException;
import ru.skepro.homework17.exception.EmployeeNotFoundException;
import ru.skepro.homework17.exception.EmployeeStorageIsFullException;
import ru.skepro.homework17.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String,Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();

    }
    @Override
    public Employee add(String firstName, String lastName) {

        Employee employee = new Employee(firstName,lastName);

        if (employees.containsKey(employee.getFullNAme())){
            throw new EmployeeAlreadyAddedException();
        }

        employees.put(employee.getFullNAme(),employee);

        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        Employee employee = new Employee(firstName,lastName);

        if (!employees.containsKey(employee.getFullNAme())){
            throw new EmployeeNotFoundException();
        }

        employees.remove(employee.getFullNAme());


        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);

        if (!employees.containsKey(employee.getFullNAme())){
            throw new EmployeeNotFoundException();
        }


        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}
