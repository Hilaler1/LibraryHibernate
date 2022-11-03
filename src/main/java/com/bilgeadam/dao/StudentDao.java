package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.Student;

public class StudentDao implements IRepository<Student> {

	@Override
	public void create(Student entity) {
		Session session = null;

		try {
			session = databaseConnection();
			session.getTransaction().begin();
			System.out.println(session);
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Student data is added to DB");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while adding Student data.");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void update(long studentId, Student entity) {
		Session session = null;
		try {
			Student updateStudent=find(studentId);
			updateStudent.setUsername(entity.getUsername());
			updateStudent.setPassword(entity.getPassword());
			updateStudent.setBookList(entity.getBookList());
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateStudent);
			session.getTransaction().commit();
			System.out.println("succesfully updated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while UPDATING student data.");
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(long studentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student find(long studentId) {
		Student student=null;
		Session session=databaseConnection();
		try {
			student = session.find(Student.class, studentId);
			if(student!=null) {
				System.out.println("Found student : " + student);
			} else {
				System.out.println("student not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND student data.");
		} finally {
			session.close();
		}
		return student;
	}

}
