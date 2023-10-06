package id.ac.ittelkompwt.Bookshop.service;

import id.ac.ittelkompwt.Bookshop.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public  Employee getEmployeeById(String employeeId);

    public List<Employee> getAllEmployee();

    public Employee updateEmployee(Employee employeeId);

    public void deleteEmployee(String employeeId);

//    List<Book> searchBookTitle(String title);
}
