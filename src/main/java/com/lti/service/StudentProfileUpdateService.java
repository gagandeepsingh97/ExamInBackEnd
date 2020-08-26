package com.lti.service;

import com.lti.dto.StudentProfileUpdateDto;
import com.lti.entity.Student;

public interface StudentProfileUpdateService {

	//String updatePhone(String email, String password, String phoneNo);
	String updateCity(String email, String password, String city);
	String updateState(String email, String password, String state);
	String updatePhone(StudentProfileUpdateDto studentprofileupdatedto);
}
