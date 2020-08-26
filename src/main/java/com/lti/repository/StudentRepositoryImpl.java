package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	

		@Override
		@Transactional
		public void save(Student student) {
			entityManager.persist(student);
			//entityManager.flush();
			System.out.println(student.getState());
		}
		
		
		@Override
		public List<Student> findAll(){
			return entityManager.createNamedQuery("fetch-all").getResultList();
		}
		
		@Override
		public boolean StudentPresent(String email) {
			return (Long) entityManager
					.createQuery("select count(c.id) from Student c where c.email = :em")
					.setParameter("em", email)
					.getSingleResult() == 1 ? true : false;
		}
		
		@Override
		public int findByEmailPassword(String email, String password) {
			return (Integer) entityManager
					.createQuery("select c.id from Student c where c.email = :em and c.password = :pw")
					.setParameter("em", email)
					.setParameter("pw", password)
					.getSingleResult();
		}


		@Override
		@Transactional
		public Student findById(int id) {
			// TODO Auto-generated method stub
			//System.out.println(id);
			return entityManager.find(Student.class,id);
		}

}
