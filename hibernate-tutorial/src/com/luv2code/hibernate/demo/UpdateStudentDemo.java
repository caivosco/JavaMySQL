package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
						
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
						
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
						
			System.out.println("Get Complete " + myStudent);
			
			System.out.println("updating student...");
			myStudent.setFirstName("fernando");
			
			session.getTransaction().commit();
			
			// new transaction
			
			session = factory.getCurrentSession(); //
			session.beginTransaction(); //
			
			System.out.println("Update for email");
			session.createNativeQuery("update Student set email='foo@gmail.com' where first_name='Jenny'").executeUpdate();
				
			
			session.getTransaction().commit(); // 
						
			System.out.println("Done!");
			
		}
		
		finally {
			factory.close();
		}

	}

}
