package ru.skepro.homework17.controller;

import org.springframework.web.bind.annotation.*;
import ru.skepro.homework17.model.Employee;
import ru.skepro.homework17.service.DepartmentService;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping ("/{departmentId}/salary/sum")
    public Integer getDepartmentSalarySum(@PathVariable() int departmentId){
        return departmentService.getDepartmentSalarySum(departmentId);}

    @GetMapping ("/{departmentId}/salary/max")
    public Employee findEmployeeWitMaxSalary(@PathVariable() int departmentId){
        return departmentService.findEmployeeWitMaxSalary(departmentId);
    }

    @GetMapping ("/{departmentId}/salary/min")
    public Employee findEmployeeWitMinSalary(@PathVariable() int departmentId){
        return departmentService.findEmployeeWitMaxSalary(departmentId);
    }
    @GetMapping ("/employees")
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return departmentService.findEmployeesByDepartment();
    }
    @GetMapping (value = "/{departmentId}/employees")
    public Collection<Employee> findEmployeesByDepartment(@PathVariable int departmentId) {
        return departmentService.findEmployeesByDepartment(departmentId);
    }




}
