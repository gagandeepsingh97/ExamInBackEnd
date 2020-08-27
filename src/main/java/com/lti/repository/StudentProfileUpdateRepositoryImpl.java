package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Student;

@Repository
public class StudentProfileUpdateRepositoryImpl implements StudentProfileUpdateRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	
//
//	@Override
//	public Student findByEmail(String email) {
//		// TODO Auto-generated method stub
//		//return null;
//		//return entityManager.find(Student.class,email);
//	}



//	@Override
//	public String updatePhone(String phoneNo) {
//		// TODO Auto-generated method stub
//		return null;
//	}



	@Override
	public String updateCity(int id, String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateState(int id, String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void updatePhone(String em, String ph) {
		// TODO Auto-generated method stub
		String query = "UPDATE Student SET phoneNo=:p WHERE email=:e";
		Query q = (Query)this.entityManager.createQuery(query);
		q.setParameter("p", ph);
		q.setParameter("e", em);
		q.executeUpdate();
		System.out.println("Phone Number Updated. REPO    " + em + ph);
	}

}
