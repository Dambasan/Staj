//package com.yusuf.jdbc;
//
//import javax.sql.DataSource;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//public class EmployeeDao extends BaseDao {
//
//
//    public List<Employee> insertBatch(List<Employee> employees) throws SQLException {
//        String SQL = "INSERT INTO employee (fname, minit, lname, ssn, bdate, address, sex, salary, superssn, dno) " +
//                "VALUES(?,?,?,?,?,?,?,?,?,?)";
//        int count1 = 0;
//        PreparedStatement pstmt = connection.prepareStatement(SQL);
//        connection.setAutoCommit(false);
//        List<String> ssns = new ArrayList<>();
//        for (int i = 0; i < employees.size(); i++) {
//            pstmt.setString(1, employees.get(i).getFname());
//            pstmt.setString(2, employees.get(i).getMinit());
//            pstmt.setString(3, employees.get(i).getLname());
//            pstmt.setString(4, employees.get(i).getSsn());
//            pstmt.setDate(5, employees.get(i).getBdate());
//            pstmt.setString(6, employees.get(i).getAddress());
//            pstmt.setString(7,employees.get(i).getSex());
//            pstmt.setInt(8, employees.get(i).getSalary());
//            pstmt.setString(9, employees.get(i).getSuperssn());
//            pstmt.setInt(10, employees.get(i).getDno());
//            pstmt.addBatch();
//            count1 = count1 + 1;
//            ssns.add(employees.get(i).getSsn());
//            System.out.println(count1);
//        }
//
//
//        int[] count = pstmt.executeBatch();
//
//        connection.commit();
//
//        return findEmployees(ssns);
//    }
//
//    public List<Employee> updateBatch(List<Employee> employees) throws SQLException {
//        String SQL = "UPDATE employee SET fname=? , minit=? , lname=? , bdate=? , address=? , sex=? , salary=? , superssn=? , dno=? WHERE ssn = ?";
//        int count1 = 0;
//        PreparedStatement pstmt = connection.prepareStatement(SQL);
//        connection.setAutoCommit(false);
//
//        List<String> ssns = new ArrayList<>();
//        for (int i = 0; i < employees.size(); i++) {
//            pstmt.setString(1, employees.get(i).getFname());
//            pstmt.setString(2, employees.get(i).getMinit());
//            pstmt.setString(3, employees.get(i).getLname());
//            pstmt.setDate(4, employees.get(i).getBdate());
//            pstmt.setString(5, employees.get(i).getAddress());
//            pstmt.setString(6,employees.get(i).getSex());
//            pstmt.setInt(7, employees.get(i).getSalary());
//            pstmt.setString(8, employees.get(i).getSuperssn());
//            pstmt.setInt(9, employees.get(i).getDno());
//            pstmt.setString(10,employees.get(i).getSsn());
//            pstmt.addBatch();
//            count1 = count1 + 1;
//            System.out.println(count1);
//            ssns.add(employees.get(i).getSsn());
//        }
//
//
//        int[] count = pstmt.executeBatch();
//
//        connection.commit();
//
//        return findEmployees(ssns);
//    }
//
//    public Employee findEmployee(String ssn) {
//        try {
//            String queryfindEmployee = "select fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno from employee where ssn=?";
//            PreparedStatement preparedStatement = connection.prepareStatement(queryfindEmployee);
//            preparedStatement.setString(1, ssn);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (!rs.next()) {
//                return null;
//            }
//            createEmployee(rs);
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        return null;
//    }
//
//    public Employee insertEmployee(Employee employee) {
//        try {
//            String queryInsertEmployee = "insert into employee(fname, minit, lname, ssn, bdate, address, sex, salary, superssn, dno) values(?,?,?,?,?,?,?,?,?,?)";
//            PreparedStatement pstatement = connection.prepareStatement(queryInsertEmployee);
//            pstatement.setString(1, employee.getFname());
//            pstatement.setString(2, employee.getMinit());
//            pstatement.setString(3, employee.getLname());
//            pstatement.setString(4, employee.getSsn());
//            pstatement.setDate(5, employee.getBdate());
//            pstatement.setString(6, employee.getAddress());
//            pstatement.setString(7, employee.getSex());
//            pstatement.setInt(8, employee.getSalary());
//            pstatement.setString(9, employee.getSuperssn());
//            pstatement.setInt(10, employee.getDno());
//            pstatement.executeUpdate();
//            return findEmployee(employee.getSsn());
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        return null;
//    }
//
//    public Employee updateEmployee(Employee employee) {
//        try {
//            String query = "update employee set fname=?, minit=?, lname=?, address=?, sex=?, salary=?, dno=?, bdate=to_date(?, 'dd/MM/YYYY'), superssn=? where ssn=?";
//            PreparedStatement pstatement = connection.prepareStatement(query);
//            pstatement.setString(1, employee.getFname());
//            pstatement.setString(2, employee.getMinit());
//            pstatement.setString(3, employee.getLname());
//            pstatement.setString(4, employee.getAddress());
//            pstatement.setString(5, employee.getSex());
//            pstatement.setInt(6, employee.getSalary());
//            pstatement.setInt(7, employee.getDno());
//            pstatement.setString(8, new SimpleDateFormat("dd/MM/yyyy").format(employee.getBdate()));
//            pstatement.setString(9, employee.getSuperssn());
//            pstatement.setString(10, employee.getSsn());
//            int i = pstatement.executeUpdate();
//            System.out.println("Başarıyla Düzenlendi " + i + " Kayit");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return findEmployee(employee.getSsn());
//    }
//
//    public void deleteEmployee(Employee employee) {
//        try {
//            String querydeleteEmployee = "delete from employee where ssn=?";
//            PreparedStatement preparedStatement = connection.prepareStatement(querydeleteEmployee);
//            preparedStatement.setString(1, employee.getSsn());
//            preparedStatement.executeUpdate();
//            System.out.println("Başarıyla Silindi");
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//    }
//
//    public List<Employee> findEmployees(List<String> ssnList) {
//        try {
//            String inSql = String.join(",", Collections.nCopies(ssnList.size(), "?"));
//            String sql = String.format("Select fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno from employee where ssn in (%s)", inSql);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            for (int i = 0; i < ssnList.size(); i++) {
//                preparedStatement.setString(i + 1, ssnList.get(i));
//            }
//            ResultSet rs = preparedStatement.executeQuery();
//            List<Employee> employees = new ArrayList<>();
//            while (rs.next()) {
//                employees.add(createEmployee(rs));
//            }
//            return employees;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private Employee createEmployee(ResultSet rs) throws SQLException {
//        Employee foundEmployee = new Employee();
//        foundEmployee.setFname(rs.getString("fname"));
//        foundEmployee.setLname(rs.getString("lname"));
//        foundEmployee.setMinit(rs.getString("minit"));
//        foundEmployee.setSsn(rs.getString("ssn"));
//        foundEmployee.setBdate(rs.getDate("bdate"));
//        foundEmployee.setAddress(rs.getString("address"));
//        foundEmployee.setSex(rs.getString("sex"));
//        foundEmployee.setSalary(rs.getInt("salary"));
//        foundEmployee.setSuperssn(rs.getString("superssn"));
//        foundEmployee.setDno(rs.getInt("dno"));
//        return foundEmployee;
//    }
//}
