package com.bilgeadam.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.BookDetail;
import com.bilgeadam.entity.Student;

public class HibernateSession {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (HibernateSession.sessionFactory == null) {
			HibernateSession.sessionFactory = createSessionFactory();
		}

		return HibernateSession.sessionFactory;

	}

	private static SessionFactory createSessionFactory() {
		Configuration conf = new Configuration();
		conf.addAnnotatedClass(Book.class);
		conf.addAnnotatedClass(BookDetail.class);
		conf.addAnnotatedClass(Student.class);
		sessionFactory = conf.configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("connection to postgresql via hibernate successful.");
		return sessionFactory;

	}

}
