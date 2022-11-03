package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.BookDetail;

import jakarta.persistence.TypedQuery;

public class BookDetailDao implements IRepository<BookDetail> {

	@Override
	public void create(BookDetail entity) {
		Session session = null;

		try {
			session = databaseConnection();
			session.getTransaction().begin();
			System.out.println(session);
			session.merge(entity);
			session.getTransaction().commit();
			System.out.println("Bookdetail data is added to DB");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while adding Bookdetail data.");
		} finally {
			session.close();
		}
	}

	@Override
	public void update(long bookDetailId, BookDetail entity) {
		Session session = null;
		try {
			BookDetail updateBookDetail = find(bookDetailId);
			updateBookDetail.setBook(entity.getBook());
			updateBookDetail.setBorrowDate(entity.getBorrowDate());
			updateBookDetail.setReturnDate(entity.getReturnDate());
			updateBookDetail.setBorrowed(entity.isBorrowed());
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateBookDetail);
			session.getTransaction().commit();
			System.out.println("succesfully updated");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while UPDATING Bookdetail data.");
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(long bookDetailId) {
		Session session = null;
		try {
			BookDetail deleteBookDetail = find(bookDetailId);
			if (deleteBookDetail != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteBookDetail);
				session.getTransaction().commit();
				System.out.println("bookdetail deleted succesfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING bookdetail data.");
		} finally {
			session.close();
		}

	}

	@Override
	public List<BookDetail> listAll() {
		Session session = databaseConnection();
		String hql = "select b from BookDetail as b";
		TypedQuery<BookDetail> typedQuery = session.createNamedQuery(hql, BookDetail.class);
		List<BookDetail> bookDetailList = typedQuery.getResultList();
		return bookDetailList;
	}

	@Override
	public BookDetail find(long bookDetailId) {
		BookDetail bookDetail = null;
		Session session = databaseConnection();
		try {
			bookDetail = session.find(BookDetail.class, bookDetailId);
			if (bookDetail != null) {
				System.out.println("Found bookdetail : " + bookDetail);
			} else {
				System.out.println("bookdetail not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND book detail data.");
		} finally {
			session.close();
		}
		return bookDetail;
	}

}
