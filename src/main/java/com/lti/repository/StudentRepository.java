package com.lti.repository;

import java.util.List;

import com.lti.entity.Student;

public interface StudentRepository {

	void save(Student student);

	Student findById(int id);

	List<Student> findAll();

	int findByEmailPassword(String email, String password);
	
	boolean StudentPresent(String email);

}