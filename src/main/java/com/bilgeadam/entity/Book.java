package com.bilgeadam.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tbl_book")
@ToString
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookid;
	@Column(name = "book_name", nullable = false)
	private String name;
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="detail_id", referencedColumnName = "bookDetailId")
	private BookDetail bookDetail;
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "studentId")
	private Student student;
	

}
