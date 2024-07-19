package com.yusuf.jdbc;

import jakarta.persistence.*;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    private String dname;
    @Id
    private Integer dnumber;
    private String mgrssn;
    private Date mgrstartdate;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<Employee> employees;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDnumber() {
        return dnumber;
    }

    public void setDnumber(Integer dnumber) {
        this.dnumber = dnumber;
    }

    public String getMgrssn() {
        return mgrssn;
    }

    public void setMgrssn(String mgrssn) {
        this.mgrssn = mgrssn;
    }

    public Date getMgrstartdate() {
        return mgrstartdate;
    }

    public void setMgrstartdate(Date mgrstartdate) {
        this.mgrstartdate = mgrstartdate;
    }

    public Department(String dname, Integer dnumber, String mgrssn, Date mgrstartdate) {
        this.dname = dname;
        this.dnumber = dnumber;
        this.mgrssn = mgrssn;
        this.mgrstartdate = mgrstartdate;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "dname='" + dname + '\'' +
                ", dnumber=" + dnumber +
                ", mgrssn='" + mgrssn + '\'' +
                ", mgrstartdate=" + mgrstartdate +
                '}';
    }
}
