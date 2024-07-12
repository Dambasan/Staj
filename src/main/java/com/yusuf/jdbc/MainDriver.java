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
        Employee employee = session.find(Employee.class, "38383838");
        System.out.println(employee);
        employee.setFname("Yusuf");
        session.persist(employee);
        session.find(Employee.class, "38383838");
        System.out.println(employee);
        transaction.commit();
        try{
            //add your hibernate code to manipulate data
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}