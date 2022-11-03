package com.bilgeadam.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_bookdetail")
@ToString
public class BookDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookDetailId;
	@Column (name = "borrow_status")
	private boolean isBorrowed;
	@Column (name= "book_borrowed_date")
	private LocalDate borrowDate;
	@Column (name = "book_return_date")
	private LocalDate returnDate;
	@OneToOne (mappedBy = "bookDetail")
	private Book book;
	

}
