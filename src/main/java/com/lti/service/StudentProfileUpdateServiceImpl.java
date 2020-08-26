package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.StudentProfileUpdateDto;
import com.lti.repository.StudentProfileUpdateRepository;

@Service
public class StudentProfileUpdateServiceImpl implements StudentProfileUpdateService {
	
	
	@Autowired
	StudentProfileUpdateRepository repo;
	
	
	//public String updatePhone(String email, String password, String phoneNo) {
	public String updatePhone(StudentProfileUpdateDto studentprofileupdatedto) {
		String em = studentprofileupdatedto.getEmail();
		String ph = studentprofileupdatedto.getPhoneNo();
		repo.updatePhone(em, ph);
		return "Phone number updated SERVICE";
	}


	


	@Override
	public String updateCity(String email, String password, String city) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String updateState(String email, String password, String state) {
		// TODO Auto-generated method stub
		return null;
	}

}
