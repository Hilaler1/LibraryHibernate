package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.Book;

import jakarta.persistence.TypedQuery;

public class BookDao implements IRepository<Book> {

	@Override
	public void create(Book entity) {
		Session session = null;

		try {
			session = databaseConnection();
			session.getTransaction().begin();
			System.out.println(session);
			session.merge(entity);
			session.getTransaction().commit();
			System.out.println("Book data is added to DB");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while adding Book data.");
		} finally {
			session.close();
		}
	}

	@Override
	public void update(long bookid, Book entity) {
		Session session = null;
		try {
			Book updateBook = find(bookid);
			updateBook.setName(entity.getName());
			updateBook.setStudent(entity.getStudent());
			updateBook.setBookDetail(entity.getBookDetail());

			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateBook);
			session.getTransaction().commit();
			System.out.println("succesfully updated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while UPDATING Book data.");
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(long bookId) {
		Session session = null;
		try {
			Book deleteBook = find(bookId);
			if (deleteBook != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteBook);
				session.getTransaction().commit();
				System.out.println("book deleted succesfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING book data.");
		} finally {
			session.close();
		}

	}

	@Override
	public List<Book> listAll() {
		Session session = databaseConnection();
		String hql = "select b from Book as b";
		TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
		List<Book> bookList = typedQuery.getResultList();
		return bookList;
	}

	@Override
	public Book find(long bookid) {
		Book book=null;
		Session session=databaseConnection();
		try {
			book = session.find(Book.class, bookid);
			if(book!=null) {
				System.out.println("Found book : " + book);
			} else {
				System.out.println("book not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND book data.");
		} finally {
			session.close();
		}
		return book;
	}

}
