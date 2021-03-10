package com.jbk.test;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;

import com.jbk.model.Teacherr;

public class ReadData {
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure().addAnnotatedClass(Teacherr.class);
		SessionFactory sf =cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction ts = s.beginTransaction();
		try 
		{
			List Teacherr = (List) s.createQuery("From Teacherr").list();
			Iterator iterator=((java.util.List) Teacherr).iterator();
			while(iterator.hasNext())
			{
				Teacherr te = (com.jbk.model.Teacherr) iterator.next();

				System.out.println(te.getTid());
				System.out.println(te.getTname());
				System.out.println(te.getSubject());
				System.out.println(te.getTsalary());
			}





		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}