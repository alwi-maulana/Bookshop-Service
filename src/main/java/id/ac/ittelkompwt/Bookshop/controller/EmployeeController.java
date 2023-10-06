package id.ac.ittelkompwt.Bookshop.controller;

import id.ac.ittelkompwt.Bookshop.entity.Employee;
import id.ac.ittelkompwt.Bookshop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee createMember(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee) ;
    }

    @GetMapping("/{employeeId}")
    public Employee getMemberById(@PathVariable String employeeId) {
        return  employeeService.getEmployeeById(employeeId);
    }

    @GetMapping
    public List<Employee> getAllMember() {
        return employeeService.getAllEmployee();
    }

    @PutMapping
    public Employee updateMember(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteMember(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
