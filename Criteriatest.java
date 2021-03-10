package Com.Criteria.testCriteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import Com.Criteria.Entity.Studentt.Student;
import Com.Criteria.HibernateConfiguration.HibernateConfiguration;


public class Criteriatest {

	public static void main(String[] args)
	{
		SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
		Session session=sessionFactory.openSession();
		System.out.println("Connection Established  Sucessfully");
		Transaction transaction=session.beginTransaction();
		//Criteria criteria=session.createCriteria(Student.class);
		Criteria criteria = session.createCriteria(Student.class);

		//criteria.add(Restrictions.isEmpty("studentAge"));
		//List r=criteria.list();
		//System.out.println(r);
		criteria.add(Restrictions.isNotEmpty("studentAge"));
		criteria.addOrder(Order.desc("studentFirstName"));
		System.out.println("Using ascending order  ");
		List<Student>students2=criteria.list();
		for (Student student2 : students2)
		{
			System.out.println(student2);
		}
		/*List<Student>students1=criteria.list();
		for (Student students11 : students1)
		{
			System.out.println(students11);

		}*/
		
		
		
		
		
		
		criteria.setFirstResult(2);

		criteria.setMaxResults(4);
		//criteria.s
		//System.out.println(criteria.toString());

		/*

		}*/


		

	}

}
