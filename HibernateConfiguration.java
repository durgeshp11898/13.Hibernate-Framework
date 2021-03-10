package Com.Criteria.HibernateConfiguration;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Com.Criteria.Entity.Studentt.Student;

public class HibernateConfiguration
{
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory()
	{
		Configuration configuration= new Configuration();
		configuration.configure().addAnnotatedClass(Student.class);
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
		
	}

}
