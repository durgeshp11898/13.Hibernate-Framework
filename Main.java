package com.hibernate.Hibernate.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Hibernate.Util.HibernateUtil;
import com.hibernate.employee.Employee;

public class Main {

	Scanner sc = new Scanner(System.in);

	public void saveEmployee()
	{
		try
		{

			Configuration cfg = new Configuration();
			cfg.configure().addAnnotatedClass(Employee.class);
			SessionFactory sf = cfg.buildSessionFactory();
			Session s = sf.openSession();
			Transaction ts = s.beginTransaction();

			System.out.println("Enter Records to insert");
			int nn=sc.nextInt();
			for(int i=0;i<nn;i++)
			{
				System.out.println("Enter eid  :");
				int idd=sc.nextInt();
				System.out.println("Enter ename  :");
				String ss=sc.next();
				System.out.println("Enter salary  :");
				int sall=sc.nextInt();
				Employee emp = new Employee();
				emp.setId(idd);
				emp.setName(ss);
				emp.setSal(sall);
				s.save(emp);
			}
			ts.commit();;
			System.out.println("Records inserted sucessessfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	private void DisplayEmployee()
	{

		try
		{

			Configuration cfg = new Configuration();
			cfg.configure().addAnnotatedClass(Employee.class);
			SessionFactory sf = cfg.buildSessionFactory();
			Session s = sf.openSession();
			Transaction ts = s.beginTransaction();

			List employee = s.createQuery("from Employee").list();

			for (Iterator iterator = employee.iterator(); iterator.hasNext();) 
			{
				Employee employee1 = (Employee) iterator.next();
				System.out.println(employee1.getId()+"\t"+employee1.getName() + "\t"
						+ "\t" + employee1.getSal());
			}
			ts.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
	private void deleteEmployee()
	{
		try
		{
			Configuration cfg = new Configuration();
			cfg.configure().addAnnotatedClass(Employee.class);
			SessionFactory sf = cfg.buildSessionFactory();
			Session s = sf.openSession();
			Transaction ts = s.beginTransaction();
			System.out.println("Enter which employee to delete  : ");
			int del=sc.nextInt();
			Employee ee=new Employee();
			ee.setId(del);
			s.delete(ee);
			ts.commit();
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
	}
	private void GroupbyEmployee() 
	{
		try
		{
			Configuration cfg = new Configuration();
			cfg.configure().addAnnotatedClass(Employee.class);
			SessionFactory sf = cfg.buildSessionFactory();
			Session s = sf.openSession();
			// EntityManager em = emf.createEntityManager();  

			Transaction ts = s.beginTransaction();
			CriteriaBuilder builder=s.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery=builder.createQuery(Object[].class);
			Root<Employee> root = criteriaQuery.from(Employee.class);
			//criteriaQuery.multiselect(root.get("id"),builder.count(Employee);
			criteriaQuery.multiselect(root.get("id"),builder.count(root)).groupBy(root.get("sal"));

			System.out.print("id");  
			System.out.println("\t count");  
			List<Object[]> list = s.createQuery(criteriaQuery).getResultList();  
			for(Object[] object : list){  
				System.out.println(object[0] + "     " + object[1]);  

			}

			//String hql="SELECT SUM(sal),name From Employee GROUP BY name ";


			//	ts.commit();
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		Main main= new Main();
		//main.saveEmployee();
		//main.DisplayEmployee();
		//main.deleteEmployee();
		//main.DisplayEmployee();
		//main.updateEmployee();
		main.DisplayEmployee();
		main.GroupbyEmployee();

	}


	/*		private void updateEmployee()
	{
		try
		{
			Configuration cfg = new Configuration();
			cfg.configure().addAnnotatedClass(Employee.class);
			SessionFactory sf = cfg.buildSessionFactory();
			Session s = sf.openSession();
			Transaction ts = s.beginTransaction();

			String queryString = "from Employee where sal = :sal";
		          Query query = session.createQuery(queryString);
			            query.setInteger("sal", 50000);
			            Employee employee = (Employee) query.uniqueResult();
			            employee.setSal(60000);
			            session.update(employee);
			            System.out.println("Employee records updated!");

			//query = s.createQuery(queryString);
			 = s.createQuery(queryString);*/
	//Qus.createQuery(queryString);
	//Employee eee=new Employee();
	//eee.s
	/*	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}*/
}	 







