package com.lti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.lti.controller.StudentController.Status.StatusType;
import com.lti.dto.LoginDto;
import com.lti.entity.Student;
import com.lti.exception.StudentServiceException;
import com.lti.service.StudentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @PostMapping("/registration")
    public Status register(@RequestBody Student student) {
        try {
            studentService.register(student);
            Status status = new Status();
            status.setStatus(StatusType.SUCCESS);
            status.setMessage("Registration Successfull");
            return status;
        }
        catch(StudentServiceException e) {
            Status status = new Status();
            status.setStatus(StatusType.FAILURE);
            status.setMessage(e.getMessage());
            return status;
        }
        
    }
    
//    @PostMapping("/viewreport")
//    public RandomClass viewreport(@RequestBody Student student) {
//    	
//    }
    
    
    
    
    @PostMapping("/login")
    //@PostMapping(path="/login", consumes ="application/json")
    public LoginStatus login(@RequestBody LoginDto loginDto) {
        try {
        	//System.out.println(loginDto.getEmail());
            Student student = studentService.login(loginDto.getEmail(), loginDto.getPassword());
            LoginStatus loginStatus = new LoginStatus();
            loginStatus.setStatus(StatusType.SUCCESS);
            loginStatus.setMessage("Login Successful");
            loginStatus.setStudentId(student.getStudentId());
            loginStatus.setName(student.getName());
            return loginStatus;
            
        }
        catch(StudentServiceException e) {
            LoginStatus loginStatus = new LoginStatus();
            loginStatus.setStatus(StatusType.FAILURE);
            loginStatus.setMessage(e.getMessage());
            return loginStatus;
        }
        
    }
    
    public static class LoginStatus extends Status{
        private int studentId;
        private String name;
        public int getStudentId() {
            return studentId;
        }
        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        
        
    }
    
    
    public static class Status{
        private StatusType status;
        private String message;
        
        public static enum StatusType{
            SUCCESS,FAILURE;
        }


        public StatusType getStatus() {
            return status;
        }


        public void setStatus(StatusType status) {
            this.status = status;
        }


        public String getMessage() {
            return message;
        }


        public void setMessage(String message) {
            this.message = message;
        }
        
        
    }
    
}


