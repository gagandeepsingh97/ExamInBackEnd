package com.lti.repository;
import com.lti.entity.Student;

public interface StudentProfileUpdateRepository {

	//String updatePhone(String phoneNo);
	String updateCity(int id, String city);
	String updateState(int id, String state);
	//Student findByEmail(String email);
	void updatePhone(String email, String phoneNo);
}
