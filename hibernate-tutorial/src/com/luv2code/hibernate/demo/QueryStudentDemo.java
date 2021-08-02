package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
						
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			System.out.println("\n\nall Students ");
			displayStudents(theStudents);
			
			//
			theStudents = session.createQuery("from Student s where s.lastName='Bonita' ").getResultList();
			
			System.out.println("\n\nStudents with last name of Bonita");
			displayStudents(theStudents);
			
			//
			theStudents = 
					session.createQuery("from Student s where"
							+ " s.lastName='Bonita' OR s.firstName='Carlos'").getResultList();
			
			System.out.println("\n\nStudents with last name of bonita or first name of Carlos");
			displayStudents(theStudents);			
			
			//
			theStudents = session.createQuery("from Student s where"
					+ " s.email like '%abc.com' ").getResultList(); 
			System.out.println("\n\nstudents with domain's email abc.com");
			displayStudents(theStudents);		
			
			
			session.getTransaction().commit();
			
			System.out.println("done!");
		}
		
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
