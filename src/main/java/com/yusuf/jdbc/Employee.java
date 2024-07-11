package com.yusuf.jdbc;

import java.io.Reader;
import java.sql.Date;

public class Employee {
    private String fname;
    private String minit;
    private String lname;
    private String ssn;
    private Date bdate;
    private String address;
    private String sex;
    private int salary;
    private String superssn;
    private int dno;

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
                ", superssn='" + superssn + '\'' +
                ", dno=" + dno +
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

    public String getSuperssn() {
        return superssn;
    }

    public void setSuperssn(String superssn) {
        this.superssn = superssn;
    }

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

    public Employee(String fname, String minit, String lname, String ssn, Date bdate, String address, String sex, int salary, String superssn, int dno) {
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.ssn = ssn;
        this.bdate = bdate;
        this.address = address;
        this.sex = sex;
        this.salary = salary;
        this.superssn = superssn;
        this.dno = dno;
    }
}
