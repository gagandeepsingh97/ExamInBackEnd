package com.lti.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


@Repository
public class SubjectRepositoryImpl implements SubjectRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public int getSubjectIdFromSubjectName(String subjectName) {
		BigDecimal subjectId =  (BigDecimal) this.entityManager.createNativeQuery("select SUBID from SUBJECT where SUBLEVEL = 1 AND SUBNAME = ?")
				//.setParameter(1, 1)
				.setParameter(1, subjectName)
				.getSingleResult();  
//				entityManager
//				.createNativeQuery("select SUBID from SUBJECT where SUBLEVEL = ? AND SUBNAME = ?")
//				.setParameter(2, "1")
//				.setParameter(1, subjectName)
//				.getSingleResult();
		System.out.println("-----> subject ID of level 1 " + subjectId);
		Integer finalSubjectId = subjectId.intValue();//.intValue();
		
		
		return (int)finalSubjectId;
	}

}