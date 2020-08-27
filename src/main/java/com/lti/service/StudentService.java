package com.lti.service;

import java.util.List;

import com.lti.dto.StudentDto;
import com.lti.entity.Student;

public interface StudentService {

    void register(Student student);

    Student login(String email, String password);
    
    List<StudentDto> searchStudentbySub(String subjectName);
	List<StudentDto> searchStudentbyCity(String city);
	List<StudentDto> searchStudentbyState(String state);
	List<StudentDto> searchStudentbyMarks(int marks);

}