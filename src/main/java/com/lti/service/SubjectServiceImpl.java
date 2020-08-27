package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
    private SubjectRepository subjectRepo;
    
    public int getSubjectIdService(String subjectName){
    	int subjectId = subjectRepo.getSubjectIdFromSubjectName(subjectName);
    	return subjectId;
	}

}