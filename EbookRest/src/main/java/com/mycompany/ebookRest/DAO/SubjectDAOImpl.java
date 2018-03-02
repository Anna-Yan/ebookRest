package com.mycompany.ebookRest.DAO;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.ebookRest.entity.Subject;

@Repository
public class SubjectDAOImpl implements SubjectDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional	
	public List<Subject> getAllSubjects() {

		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from students";
			
		//NativeQuery<Subject> query= session.createNativeQuery(sql,Subject.class);
		//List<Subject> list = query.list();
		return new LinkedList<Subject>();		
	}

}
