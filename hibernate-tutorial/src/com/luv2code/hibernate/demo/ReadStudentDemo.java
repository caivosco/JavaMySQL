package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// creating a student 			
			System.out.println("creating new student object");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code@abc.com");
			
			session.beginTransaction();
			
			System.out.println("saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			// find out the student id
			System.out.println("saved student using generated id: " + tempStudent.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting id " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete " + myStudent);		
			
			session.getTransaction().commit();
			
			System.out.println("done!");
		}
		
		finally {
			factory.close();
		}

	}

}
