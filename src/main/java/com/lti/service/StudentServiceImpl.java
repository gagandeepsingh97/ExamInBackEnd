package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

 

import com.lti.entity.Student;
import com.lti.exception.StudentServiceException;
import com.lti.repository.StudentRepository;

 

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepository studentRepo;
    
    public void register(Student student) {
        if(!studentRepo.StudentPresent(student.getEmail())) {
            studentRepo.save(student);
        }
        else
            throw new StudentServiceException("STUDENT Already Registered");
    }
    
    public Student login(String email,String password) {
        try {
            int id = studentRepo.findByEmailPassword(email, password);
            Student student = studentRepo.findById(id);
            return student;
        }
        catch(EmptyResultDataAccessException e) {
            throw new StudentServiceException("Cannot Login.Incorrect eamil/password");
            
        }
    }

 

}
 