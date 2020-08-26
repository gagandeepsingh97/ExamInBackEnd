package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminLoginDto;
import com.lti.service.AdminService;


@RestController
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@PostMapping(path="/adminLogin")
	public boolean loginAdmin(@RequestBody AdminLoginDto adminLoginDto) {
		return service.loginAdmin(adminLoginDto);
	}

}
