package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		
		
		@SuppressWarnings("unchecked")
		@Override
		public List<Student> findStudentbySub(String subjectName) 
		{
			return (List<Student>) entityManager
			 .createQuery("from Student where studentId IN(from Report where SUBID IN (from Subject s  where s.subjectName=:sub))")
			 .setParameter("sub", subjectName)
			 .getResultList();

			
		}

		@Override
		public List<Student> findStudentbyCity(String city) 
		{

			System.out.println(city);
			 String sql = "from Student s where s.city=:c";
		        Query qry = (Query)entityManager.createQuery(sql, Student.class);
		        qry.setParameter("c", city);
		        @SuppressWarnings("unchecked")
				List<Student> students = qry.getResultList();
		        System.out.println(students);
		        return students;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Student> findStudentbyState(String state) 
		{
			return (List<Student>) entityManager
			 .createQuery("from Student where state=:s")
			 .setParameter("s", state)
			 .getResultList();

		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Student> findStudentbyMarks(int marks) 
		{
			System.out.println(marks);
			return (List<Student>) entityManager
					.createQuery(" from Student where studentId IN(from Report where marks=:m)")
					.setParameter("m", marks)
					.getResultList();
		}
		
		

}
