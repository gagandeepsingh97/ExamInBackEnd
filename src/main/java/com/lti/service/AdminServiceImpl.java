package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.AdminLoginDto;
import com.lti.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository repo;
	
	@Override
	public boolean loginAdmin(AdminLoginDto adminLoginDto) {
		// TODO Auto-generated method stub
		
		String e = adminLoginDto.getAdminEmail();
		String p = adminLoginDto.getAdminPassword();
		boolean check = repo.loginAdmin(e, p);
		if(check == true) {
			System.out.println("Login Success");
			return true;
		}
		else {
			System.out.println("Login Unsuccessful");
			return false;
		}
	}
}
