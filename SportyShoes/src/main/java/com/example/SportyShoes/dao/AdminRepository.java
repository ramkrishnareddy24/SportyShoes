package com.example.SportyShoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.example.SportyShoes.model.Admin;

@Component
@SuppressWarnings("deprecation")
public class AdminRepository {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate gethibernateTemplate() {
		return hibernateTemplate;
		
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public boolean verifyAdmin(Admin a) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction transaction  = session.beginTransaction();
		
		String hql = "from Admin where email=:email and password=:password";
		Query<Admin> query = session.createQuery(hql,Admin.class);
		query.setParameter("email", a.getEmail());
		query.setParameter("password", a.getPassword());
		List<Admin> results = query.getResultList();
		transaction.commit();
		
		return results.size()>0;
	}
}
