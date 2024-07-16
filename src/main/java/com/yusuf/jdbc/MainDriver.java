package com.yusuf.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainDriver {

    public static void main(String[] args) {

        //.configure() fetches the xml file automatically when default file name is used(hibernate.cfg.xml)
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = new Employee("Yusuf2","x", "Dambasan2","343434354", null, "İst", "M", 156234);
        employee.setDepartment(session.get(Department.class, 1));
        employee.setEmployeeManager(session.find(Employee.class, "38383838"));
        session.persist(employee);
        System.out.println(employee);
//        session.delete(session.find(Department.class, 5));
        transaction.commit();

        try{
            //add your hibernate code to manipulate data
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}