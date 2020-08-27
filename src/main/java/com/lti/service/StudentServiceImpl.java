package com.lti.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.dto.StudentDto;
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

 
    @Override
	public List<StudentDto> searchStudentbySub(String subjectName) {
		
		List<Student> studentList =  studentRepo.findStudentbySub(subjectName); 
		List<StudentDto> studentDtoList = new ArrayList<>();
		for(Student stu: studentList) 
		{
			StudentDto stuDto = new StudentDto();
			
			stuDto.setName(stu.getName());
			stuDto.setCity(stu.getCity());
			stuDto.setState(stu.getState());
			stuDto.setEmail(stu.getEmail());
			stuDto.setPhoneNo(stu.getPhoneNo());
			
			studentDtoList.add(stuDto);
	
		}
		return studentDtoList;
	} 
	
	

	@Override
	public List<StudentDto> searchStudentbyCity(String city) {
		
		//Student student = studentRepository.findById(studentId); //studentrepo
		
		List<Student> studentList =  studentRepo.findStudentbyCity(city); 
		List<StudentDto> studentDtoList = new ArrayList<>();
		for(Student stu: studentList) 
		{
			StudentDto stuDto = new StudentDto();
			
			stuDto.setName(stu.getName());
			stuDto.setCity(stu.getCity());
			stuDto.setState(stu.getState());
			stuDto.setEmail(stu.getEmail());
			stuDto.setPhoneNo(stu.getPhoneNo());
			
			studentDtoList.add(stuDto);
	
		}
		return studentDtoList;
	} 

	@Override
	public List<StudentDto> searchStudentbyState(String state) {
		List<Student> studentList =  studentRepo.findStudentbyState(state); 
		List<StudentDto> studentDtoList = new ArrayList<>();
		for(Student stu: studentList) 
		{
			StudentDto stuDto = new StudentDto();
			
			stuDto.setName(stu.getName());
			stuDto.setCity(stu.getCity());
			stuDto.setState(stu.getState());
			stuDto.setEmail(stu.getEmail());
			stuDto.setPhoneNo(stu.getPhoneNo());
			
			studentDtoList.add(stuDto);
	
		}
		return studentDtoList;
	} 
	

	@Override
	public List<StudentDto> searchStudentbyMarks(int marks) 
	{	
		List<Student> studentList =  studentRepo.findStudentbyMarks(marks); 
		List<StudentDto> studentDtoList = new ArrayList<>();

		for(Student stu: studentList) 
		{
			StudentDto stuDto = new StudentDto();
			
			stuDto.setName(stu.getName());
			stuDto.setCity(stu.getCity());
			stuDto.setState(stu.getState());
			stuDto.setEmail(stu.getEmail());
			stuDto.setPhoneNo(stu.getPhoneNo());
			
			studentDtoList.add(stuDto);
	
		}
		return studentDtoList;
	}
    

}
 