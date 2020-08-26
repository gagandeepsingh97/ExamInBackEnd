package com.lti;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//class ExamInApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}



import java.time.LocalDate;

 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

 

import com.lti.entity.Student;
import com.lti.repository.StudentRepository;

 

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class ExamInApplicationTests {
    
    @Autowired
    private StudentRepository studentRepository;

 

    @Test
    void add() {
        Student student = new Student();
        student.setStudentId(1);
        student.setName("Prabh");
        student.setEmail("Prabh@gmail.com");
        //student.setDateOfBirth(LocalDate.of(1997, 3, 16));
        student.setPassword("Prabh");
        student.setPhoneNo("1231231231");
        java.util.Date myDate = new java.util.Date("10/10/2009");
//        student.setDOB(myDate);
        student.setCity("Prabh");
        student.setState("Prabh");
        student.setQualification("Prabh");
        student.setYearCompletion("Prabh");

 

        
        studentRepository.save(student);
    }
    
    // @Test
    // void fetchByEmailandPassword() {
    //     long id = customerRepository.findByEmailPassword("prabh@gmail.com", "123@prabh");
    //     System.out.println(id);
    // }
    
    

 

}