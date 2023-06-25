package ru.skepro.homework17.service;

import org.springframework.stereotype.Service;
import ru.skepro.homework17.exception.EmployeeAlreadyAddedException;
import ru.skepro.homework17.exception.EmployeeNotFoundException;
import ru.skepro.homework17.exception.EmployeeStorageIsFullException;
import ru.skepro.homework17.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int EMPLOYEES_MAX_COUNT = 5;
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size()>=EMPLOYEES_MAX_COUNT){
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName,lastName);

        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }

        employees.add(employee);

        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        Employee employee = new Employee(firstName,lastName);

        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }

        employees.remove(employee);


        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);

        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }


        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees;
    }
}
