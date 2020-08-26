package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.StudentProfileUpdateDto;
import com.lti.service.StudentProfileUpdateService;

@RestController
public class StudentProfileUpdateController {

	@Autowired
	private StudentProfileUpdateService service;
	
	
	
	@PostMapping(path="/updatePhone")
	public String updatePhone(@RequestBody StudentProfileUpdateDto studentprofileupdatedto) {
		String res = service.updatePhone(studentprofileupdatedto);
		return res;
	}
}
