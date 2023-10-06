package id.ac.ittelkompwt.Bookshop.repository;

import id.ac.ittelkompwt.Bookshop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
