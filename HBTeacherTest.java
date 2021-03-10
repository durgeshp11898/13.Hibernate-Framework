package com.jbk.test;

import java.util.Scanner;

import org.apache.lucene.search.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import net.javaguides.hibernate.util.HibernateUtil;

import com.jbk.model.Teacherr;
import com.mysql.jdbc.log.Log4JLogger;

public class HBTeacherTest {

	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		try 
		{
			Configuration cfg=new Configuration();

			cfg.configure().addAnnotatedClass(Teacherr.class);

			SessionFactory sf = cfg.buildSessionFactory();

			Session s = sf.openSession();

			Transaction ts = s.beginTransaction();
			/*
		Teacherr t= new Teacherr(1, "dullu","Math", 35000);
		Teacherr t1= new Teacherr(2, "Aashu","Science", 40000);
		Teacherr t2= new Teacherr(3, "Chinu","Physics", 30000);
		Teacherr t3= new Teacherr(4, "Golu","Chemestry", 35000);
		Teacherr t4= new Teacherr(5, "Milu","Bio", 30000);

		s.save(t);
		s.save(t1);
		s.save(t2); 
		s.save(t3);
		s.save(t4);
			 */
			System.out.println("Enter how many teachrs do you want");
			int n=sc.nextInt();
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter Teacher id  :");
				int id=sc.nextInt();
				System.out.println("Enter Teacher Name   :");
				String s1 =sc.next();
				System.out.println("Enter Teacher Subject  :");
				String sub=sc.next();
				System.out.println("Enter Salary  :");
				double sal=sc.nextDouble();

				Teacherr t = new Teacherr(id, s1, sub, sal);
				s.save(t);

			}
			
			//javax.management.Query q=s.createQuery("select * from teacherr");
			/*Display Data from dataase */
			//SessionFactory sf1 =Hibernate.getSessionFactory();
			System.out.println("Which teacher id to delete  :");
			int del=sc.nextInt();
			Teacherr tt=new Teacherr();
		
			tt.setTid(del);
			s.delete(tt);
			System.out.println("remove Data Sucessfully from database");
			ts.commit();

	//		Session session = 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}