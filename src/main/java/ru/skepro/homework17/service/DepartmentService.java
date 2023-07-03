package ru.skepro.homework17.service;

import ru.skepro.homework17.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWitMaxSalary(int departmentId);
    Employee findEmployeeWitMinSalary(int departmentId);
    Collection<Employee> findEmployeesByDepartment(int departmentID);
    Map<Integer, List<Employee>> findEmployeesByDepartment();

}
