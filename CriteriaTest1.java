package Com.Criteria.testCriteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;

import Com.Criteria.Entity.Studentt.Student;
import Com.Criteria.HibernateConfiguration.HibernateConfiguration;

public class CriteriaTest1 {
	public static void main(String[] args) {

		SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		/*Restrictions with criteria*/
		Criteria cr = session.createCriteria(Student.class);
		/*
		// To get records having age equal 22
		//cr.add(Restrictions.eq("studentAge", 22));

		//To get records having age less than 25
		cr.add(Restrictions.lt("studentAge", 25));

		// Case sensitive form of the above restriction.
		cr.add(Restrictions.ilike("studentFirstName", "d%"));

		// To get records having age in between 22 and 25
		cr.add(Restrictions.between("studentAge", 22, 25));

		// To check if the given property is null
		cr.add(Restrictions.isNull("studentAge"));

		// To check if the given property is not null
		cr.add(Restrictions.isNotNull("studentAge"));

		// To check if the given property is empty
		cr.add(Restrictions.isEmpty("studentAge"));

		// To check if the given property is not empty
		cr.add(Restrictions.isNotEmpty("studentAge"));
		// To get records having fistName starting with zara
		cr.add(Restrictions.like("studentFirstName", "d%"));
		 */
		/*
		 AND or OR conditions using LogicalExpression restrictions

		 //OR


		Criterion age=Restrictions.lt("studentAge", 25);
		Criterion name = Restrictions.ilike("studentFirstName", "D%");
		LogicalExpression expression = Restrictions.or(age,name);
		cr.add(expression);
		LogicalExpression expression = Restrictions.and(age,name);
		cr.add(expression);

		 */

		/*Pagination Using Criteria


		cr.setFirstResult(2);//skip 1st two records
		cr.setMaxResults(5); //display 1st five records 

		 */

		/*
	    //Sorting 
		// To get records having age more than 20
		cr.add(Restrictions.gt("studentAge", 20));

		// To sort records in descening order
		cr.addOrder(Order.desc("studentAge"));

		// To sort records in ascending order
		cr.addOrder(Order.asc("studentAge"));

		 */

		/*
		// To get total row count.
		cr.setProjection(Projections.rowCount());

		// To get average of a property.
		cr.setProjection(Projections.avg("studentAge"));

		// To get distinct count of a property.
		cr.setProjection(Projections.countDistinct("studentFirstName"));

		// To get maximum of a property.
		cr.setProjection(Projections.max("studentAge"));

		// To get minimum of a property.
		cr.setProjection(Projections.min("StudentAge"));

		// To get sum of a property.
		cr.setProjection(Projections.sum("StudentAge"));


		cr.setProjection(Projections.rowCount());
		 System.out.println(cr.list());
		//System.out.println();
		 */

		java.util.List<Student>list1=cr.list();
		for (Student student : list1) 
		{
			System.out.println(student);
		}


	}

}
