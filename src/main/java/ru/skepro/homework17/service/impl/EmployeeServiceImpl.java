package ru.skepro.homework17.service.impl;

import org.springframework.stereotype.Service;
import ru.skepro.homework17.exception.EmployeeAlreadyAddedException;
import ru.skepro.homework17.exception.EmployeeNotFoundException;
import ru.skepro.homework17.model.Employee;
import ru.skepro.homework17.service.EmployeeService;
import ru.skepro.homework17.service.EmployeeValidationService;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    private final EmployeeValidationService validationService;

    public EmployeeServiceImpl(EmployeeValidationService validationService) {
        this.validationService = validationService;
        this.employees = new HashMap<>();

    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        validationService.validate(firstName, lastName);
        return addEmployee (new Employee (capitalize(firstName), capitalize (lastName)));
    }

    @Override
    public Employee add(String firstName, String lastName) {
        validationService. validate(firstName, lastName);
        return addEmployee (new Employee (capitalize(firstName), capitalize (lastName)));
    }
    @Override
    public Employee remove(String firstName, String lastName) {

        Employee employee = find (firstName, lastName);
        employees.remove(employee.getFullNAme());
        return employee;
    }



    @Override
    public Employee find(String firstName, String lastName) {
        String fullNameKey = firstName +" "+ lastName;

        if (!employees.containsKey(fullNameKey)) {
            throw new EmployeeNotFoundException();
        }


        return employees.get(fullNameKey);
    }

    @Override
    public Collection<Employee> findAll() {

        return employees.values();
    }
   private Employee addEmployee(Employee employee){
        if (employees.containsKey(employee.getFullNAme())) {
            throw new EmployeeAlreadyAddedException(employee);
        }
        employees.put(employee.getFullNAme(),employee);
        return employee;
    }
}
