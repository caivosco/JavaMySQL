package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
						
			int studentId = 2;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
						
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
						
			System.out.println("Deleting " + myStudent);
			session.delete(myStudent);
			
			// new transaction
						
			/*
			 * System.out.println("deleting based on conditions");
			 * 
			 * session.createNamedQuery("delete from student where id=2").executeUpdate();
			 */
			
			session.getTransaction().commit(); // 
						
			System.out.println("Done!");
			
		}
		
		finally {
			factory.close();
		}

	}

}
