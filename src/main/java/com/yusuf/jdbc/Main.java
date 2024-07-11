package com.yusuf.jdbc;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.findEmployee("99222902");
        if (employee != null) {
            System.out.println("Kişi bulundu");
        }
        System.out.println(employee);
        // employee.setSsn("99222902");
        //Employee inserted = employeeDao.insertEmployee(employee);
        //System.out.println(inserted);
        //inserted.setFname("Mahmut");
        //inserted.setLname("Dambo");
        //inserted.setSalary(123126);
        //inserted.setAddress("İstanbul");
        // Employee employee2 = employeeDao.updateEmployee(inserted);
        //System.out.println(employee2);
        //employeeDao.deleteEmployee(employee);
        List<String> ssnList = Arrays.asList("666666603", "666666605", "999887777", "38383838");
        List<Employee> employees = employeeDao.findEmployees(ssnList);
        employees.forEach(System.out::println);

        employees.get(0).setFname("Yusuf Gündüz");
        List<Employee> employeeList = employeeDao.updateBatch(employees);
        employeeList.forEach(System.out::println);
        List<Employee> employees2 = new ArrayList<>();
        employees2.add(new Employee("Emir", "C", "Küçük", "12815715", null, "İstanbul", "M", 27000, "222222200", 1));
        employees2.add(new Employee("Mert", "C", "Ayyıldız", "15815715", null, "Fatih", "M", 25000, "222222200", 1));
        employees2.forEach(System.out::println);
        //List<Employee> employeeList1 = employeeDao.insertBatch(employees2);
        //employeeList1.forEach(System.out::println);
    }
}