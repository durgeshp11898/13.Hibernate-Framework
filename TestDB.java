package com.jbk.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jbk.model.Employee;

public class TestDB {
	public static void main(String[] args) {
		Configuration cfg =new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx=s.beginTransaction();
		
		Employee emp=new Employee(1,"durgesh",50000);
		s.save(emp);
		tx.commit();
	}

}
