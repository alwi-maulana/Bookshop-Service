package id.ac.ittelkompwt.Bookshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_employee")
public class Employee {

    @Id
    @GeneratedValue(generator = "uuid2") //untuk generate
    @GenericGenerator(
            name = "uuid2",
            strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    private String name;

    private String role;

    private String email;

    private char status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "JOIN_DATE")
    private Date joinDate;

    public Employee() {
    }

    public Employee(String employeeId, String name, String role, String email, char status, Date joinDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.email = email;
        this.status = status;
        this.joinDate = joinDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
