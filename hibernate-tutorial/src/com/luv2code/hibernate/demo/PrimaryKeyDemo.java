package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("creating new student object");
			Student tempStudent1 = new Student("Jose", "Perez", "pepe@luv2code@abc.com");
			Student tempStudent2 = new Student("Carlos", "Garcia", "charly@luv2code@abc.com");
			Student tempStudent3 = new Student("Andrea", "Rivas", "andreita@luv2code@abc.com");
			Student tempStudent4 = new Student("Jenny", "Bonita", "jenny@luv2code@abc.com");
			
			session.beginTransaction();
			
			System.out.println("saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			
			session.getTransaction().commit();
			
			System.out.println("done!");
		}
		
		finally {
			factory.close();
		}


	}

}
