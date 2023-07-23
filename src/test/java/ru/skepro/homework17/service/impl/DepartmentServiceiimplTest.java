package ru.skepro.homework17.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skepro.homework17.exception.EmployeeNotFoundException;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.skepro.homework17.service.impl.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceiimplTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceiimpl departmentService;

@Test
    public void shouldReturnTotalSalaryByDepartmentId(){
    when(employeeService.findAll()).thenReturn(EMPLOYEES);
    assertEquals(DEPARTMENT_TOTAL_SALARU, departmentService.getDepartmentSalarySum(DEPARTMENT_ID));
}
    @Test
    public void shouldReturnEmployeeWithMaxByDepartmentId(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findEmployeeWitMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeeWithMinByDepartmentId(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWitMinSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldThrowEmployeeNitExceptionWhenFindEmployeeWithMaxSalary () {
    when(employeeService.findAll()).thenReturn(emptyList());
    assertThrows(EmployeeNotFoundException.class,() ->departmentService.findEmployeeWitMaxSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldThrowEmployeeNitExceptionWhenFindEmployeeWithMinSalary () {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,() ->departmentService.findEmployeeWitMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeesByDepartmentId(){
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEES,departmentService.findEmployeesByDepartment(DEPARTMENT_ID));

        assertEquals(singletonList(OTHER_DEPARTMENT_EMPLOYEE),departmentService.findEmployeesByDepartment(DEPARTMENT_ID2));


    }
    @Test
    public void shouldReturnAllEmployees(){
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEES_BY_DEPARTMANT_MAP,departmentService.findEmployeesByDepartment());

    }
    @Test
    public void shouldReturnEmptyMapWhenFindAllEmployees(){
        when(employeeService.findAll()).thenReturn(emptyList());

        assertEquals(emptyList(),departmentService.findEmployeesByDepartment());

    }




}
