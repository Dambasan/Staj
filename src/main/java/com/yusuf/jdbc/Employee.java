package com.yusuf.jdbc;

import jakarta.persistence.*;
import org.hibernate.FetchMode;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;

import java.sql.Date;
@DynamicUpdate
@Entity
@Table(name = "employee")
public class Employee {

    private String fname;
    private String minit;
    private String lname;
    @Id
    private String ssn;
    private Date bdate;
    private String address;
    private String sex;
    private int salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dno", referencedColumnName = "dnumber")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "superssn", referencedColumnName = "ssn")
    private Employee employeeManager;

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "fname='" + fname + '\'' +
                ", minit='" + minit + '\'' +
                ", lname='" + lname + '\'' +
                ", ssn='" + ssn + '\'' +
                ", bdate=" + bdate +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMinit() {
        return minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee getEmployeeManager() {
        return employeeManager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEmployeeManager(Employee employeeManager) {
        this.employeeManager = employeeManager;
    }

    public Employee(String fname, String minit, String lname, String ssn, Date bdate, String address, String sex, int salary) {
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.ssn = ssn;
        this.bdate = bdate;
        this.address = address;
        this.sex = sex;
        this.salary = salary;
    }
}
