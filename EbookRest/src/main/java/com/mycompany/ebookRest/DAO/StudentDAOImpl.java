package com.mycompany.ebookRest.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.ebookRest.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public List<Student> getAllStudents() {
	
		String sql = "select * from students";			
		NativeQuery<Student> query= getSession().createNativeQuery(sql,Student.class);
		List<Student> list = query.list();
		System.out.println("Studentslist"+list);
		return list;	
	}

	@Transactional
	public void saveOrUpdate(Student s) {
		getSession().saveOrUpdate(s);
		
	}

	@Transactional
	public void deleteStudent(int id) {
		Student student = getSession().get(Student.class, id);
		getSession().delete(student);
		
	}

	@Transactional
	public Student findStudentById(int id) {
		 return (Student) getSession().get(Student.class, id);
	}

}
