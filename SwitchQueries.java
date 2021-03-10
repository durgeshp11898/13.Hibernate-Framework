package com.hibernate.criteria.queries;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.configuration.HibernateConfiguration;
import com.hibernate.employe.Employee;

public class SwitchQueries {
	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		SessionFactory sessionFactory= HibernateConfiguration.getHibernateConfiguration();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("start for Execution  ");

		int choice =0;
		while(choice !=9)
		{
			System.out.println("1: Insert  Employee");
			System.out.println("2: Update Employee Name ");
			System.out.println("3: Display Records");
			System.out.println("4: Delete any Employee ");
			System.out.println("5: Agregation Functions  ");
			System.out.println("6 : Group By Clause  ");
			System.out.println("7: Order By Clause");
			System.out.println("8:Print Employe salary > 30000 & salary <60000");
			System.out.println("9: Exit From Queries of Hql");

			System.out.println("Enter Your Choice  ");
			choice=sc.nextInt();
			switch(choice)
			{

			case 1:
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
				break;

			case 2:
				Query q=session.createQuery("update Employee set employeeName=:n where id=:i");  
				System.out.println("Enter Name to u have Replace   :");
				String name=sc.next();
				System.out.println("Enter which to u have replace  :");
				long idd=sc.nextLong();
				q.setParameter("n",name);  
				q.setParameter("i",idd);  

				int status=q.executeUpdate();
				if(status==1)
					System.out.println("Updation is Sucessfully ");
				else
					System.out.println("Error : Not updated values  ");  
				break;
			case 3:
				Query query2=session.createQuery("from Employee");//here persistent class name is Emp  
				List list=query2.list();
				Iterator<Employee> iterator = list.iterator();
				while(iterator.hasNext())
				{
					System.out.println(iterator.next());
				}
				break;

			case 4:
				Query query=session.createQuery("delete from Employee where employeeId=:id");  
				System.out.println("Enter which id to be delete  :");
				long id=sc.nextLong();
				query.setParameter("id",id);  
				int del = query.executeUpdate();
				if(del==1)
					System.out.println("delete sucessfully ");
				else
					System.out.println("Error : Not deleted values  ");  
				break;

			case 5:
				int ch = 0;
				while(ch != 6)
				{
					System.out.println("1: Count Records  :");
					System.out.println("2: Avarage Salary  :");
					System.out.println("3: Minimun Salary :");
					System.out.println("4: Maximum Salary  :");
					System.out.println("5: Sum Of Salary   :");
					System.out.println("6: to Exit from Aggregation ");
					System.out.println("Enter Your Choice");
					ch=sc.nextInt();

					switch(ch)
					{
					case 1:
						Query q1=session.createQuery("select count(employeeId) from Employee");  
						List<Long> list2 = q1.list();
						System.out.println("Total Records Found are  :"+list2.get(0));

						break;
					case 2:
						Query q2=session.createQuery("select avg(employeeSalary) from Employee");  
						List<Double> list3 = q2.list();
						System.out.println("Avarage Salary of all Employee are  :"+list3.get(0));
						break;
					case 3:
						Query q3=session.createQuery("select min(employeeSalary) from Employee");  
						List<Double> list4 = q3.list();
						System.out.println("Minimum Salary is   :"+list4.get(0));
						break;

					case 4:
						Query q5=session.createQuery("select max(employeeSalary) from Employee");  
						List<Long> list6 = q5.list();
						System.out.println("Maximum Salary is  :"+list6.get(0));

						break;

					case 5:
						Query q21=session.createQuery("select sum(employeeSalary) from Employee");  
						List<Integer> list1=q21.list();  
						System.out.println("Total Sum of salary is  :"+list1.get(0));  
						break;

					case 6:
						System.out.println("Exit From Aggregations Functions");
						System.exit(0);
						break;

					}

				}
				break;
			case 6:
				System.out.println("Group By Departments of Employee and Count of that Employees");
				CriteriaBuilder builder= session.getCriteriaBuilder();
				CriteriaQuery<Object[]> criteriaQuery=builder.createQuery(Object[].class);
				Root<Employee> root = criteriaQuery.from(Employee.class);
				criteriaQuery.multiselect(root.get("employeeId"),builder.count(root)).groupBy(root.get("employeeProfile"));

				System.out.print("id");  
				System.out.println("\t Profile");  
				List<Object[]> list1 = session.createQuery(criteriaQuery).getResultList();  
				for(Object[] object : list1){  
					System.out.println(object[0]  + "     " + object[1]);  

				}

				break;

			case 7:
				System.out.println("Order by sorted Employees On asc");
				String hql = "FROM Employee e ORDER BY e.employeeName";
				Query query1 = session.createQuery(hql);
				List<Employee> employees = query1.list();
				Iterator<Employee> iterator2 = employees.iterator();
				while(iterator2.hasNext())
				{
					System.out.println(iterator2.next());
				}

				break;
			case 8:
				String hql1;
				hql1="SELECT Employee  FROM Employee AS e WHERE e.employeeSalary BETWEEN :st AND :ed ";
				Query<Employee> query3=	session.createQuery(hql1);
				System.out.println("Enter Lower Salary :");
				String lower=sc.next();
				System.out.println("Enter Higher Salary :");
				String higher=sc.next();
				query3.setParameter("st","lower");
				query3.setParameter("ed","higher");
				query3.executeUpdate();
				List<Employee> list2 = query3.list();
				Iterator< Employee> iterator3 = list2.iterator();
				while(iterator3.hasNext())
				{
					System.out.println(iterator3.next());
				}
				
			case 9:
				System.out.println("Exit From All Operations  :");
				System.exit(0);
				break;

			}
		}

	}
}