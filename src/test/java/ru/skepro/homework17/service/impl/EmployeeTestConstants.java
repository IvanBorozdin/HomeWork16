package ru.skepro.homework17.service.impl;

import ru.skepro.homework17.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTestConstants {
    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";
    public static final String FIRST_NAME2 = "Sergey";
    public static final String LAST_NAME2 = "Sergeev";
    public static final String FIRST_NAME3 = "Semen";
    public static final String LAST_NAME3 = "Semenov";

    public static final int SALARY = 100;
    public static final int MAX_SALARY = 100_000;
    public static final int DEPARTMENT_ID = 1;
    public static final int DEPARTMENT_ID2 = 2;
    public static final Employee MAX_SALARY_EMPLOYEE= new Employee(FIRST_NAME,LAST_NAME);
    public static final Employee MIN_SALARY_EMPLOYEE= new Employee(FIRST_NAME2,LAST_NAME2);
    public static final List<Employee>EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE,MIN_SALARY_EMPLOYEE);
    public static final Employee OTHER_DEPARTMENT_EMPLOYEE =new Employee(FIRST_NAME3,LAST_NAME3);

    public static final List<Employee>DIFFERENT_DEPARTMENT_EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE,MIN_SALARY_EMPLOYEE,OTHER_DEPARTMENT_EMPLOYEE);
public static final Map<Integer,List<Employee>> EMPLOYEES_BY_DEPARTMANT_MAP = DIFFERENT_DEPARTMENT_EMPLOYEES.stream()
        .collect(Collectors.groupingBy(Employee::getDepartmentId));

    public static final int DEPARTMENT_TOTAL_SALARU = EMPLOYEES.stream().mapToInt(Employee::getSalary).sum();


}
