package com.lti.service;

import com.lti.entity.Student;

public interface StudentService {

    void register(Student student);

    Student login(String email, String password);

}