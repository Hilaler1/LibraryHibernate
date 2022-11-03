package com.bilgeadam.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_student")
@ToString
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@OneToMany (mappedBy = "student")
	private List<Book> bookList= new ArrayList<>();
}
