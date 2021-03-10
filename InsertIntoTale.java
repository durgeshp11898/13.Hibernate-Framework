package com.hibernate.criteria.queries;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.configuration.HibernateConfiguration;
import com.hibernate.employe.Employee;

public class InsertIntoTale {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		SessionFactory sessionFactory= HibernateConfiguration.getHibernateConfiguration();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("start for Execution  ");

		System.out.println("Enter How Many Employee to insert  :");
		int i=sc.nextInt();
		for(int j=0;j<i;j++)
		{
			System.out.print("Enter Employee  Name   :");
			String name=sc.next();

			System.out.print("Enter Employee  Profile   :");
			String profile=sc.next();

			System.out.print("Enter Employee  Salary   :");
			double salary=sc.nextDouble();

			System.out.print("Enter Employee  Contact Number   :");
			String contact=sc.next();

			System.out.print("Enter Employee  Age   :");
			int age=sc.nextInt();

			Employee e = new Employee(name, profile, salary, contact, age);

			session.save(e);
			System.out.println();
			System.out.println("Enter "+i+" Record");
		}
		transaction.commit();
		System.out.println("All Records Inserted Sucessfully");
	}

}
