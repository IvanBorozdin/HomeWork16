package ru.skepro.homework17.service.impl;

import org.springframework.stereotype.Service;
import ru.skepro.homework17.exception.EmployeeNotFoundException;
import ru.skepro.homework17.model.Employee;
import ru.skepro.homework17.service.DepartmentService;
import ru.skepro.homework17.service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceiimpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceiimpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Integer getDepartmentSalarySum (int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee findEmployeeWitMaxSalary(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWitMinSalary(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .sorted(comparing(Employee::getFullNAme).thenComparing(Employee ::getFirstName))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return employeeService.findAll().stream()
                .sorted(comparing(Employee::getFullNAme).thenComparing(Employee ::getFirstName))
                .collect(groupingBy(Employee::getDepartmentId));
    }
}
