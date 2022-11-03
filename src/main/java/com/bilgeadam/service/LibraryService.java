package com.bilgeadam.service;

import java.time.LocalDate;

import com.bilgeadam.dao.BookDao;
import com.bilgeadam.dao.StudentDao;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.Student;

public class LibraryService {
	
	BookDao bookDao=new BookDao();
	StudentDao studentDao= new StudentDao();

	public void borrowBook(Book book,Student student) {
		book.getBookDetail().setBorrowDate(LocalDate.now());
		book.getBookDetail().setReturnDate(LocalDate.now().plusDays(30));
		book.getBookDetail().setBorrowed(true);
		book.setStudent(student);
		
		student.getBookList().add(book);
		bookDao.update(book.getBookid(), book);
		studentDao.update(student.getStudentId(), student);
	}
}
