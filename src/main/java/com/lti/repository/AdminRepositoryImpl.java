package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public boolean loginAdmin(String e, String p) {
		try {
		String query = "select adminId from Admin where adminEmail =: x and adminPassword =: y";
		Query q = (Query) this.entitymanager.createQuery(query);
		q.setParameter("x", e);
		q.setParameter("y", p);
		q.getSingleResult();
		return true;
		}
		catch(Exception NoResultException) {
			return false;
		}
	}
}