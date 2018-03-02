package com.mycompany.ebookRest.DAO;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompany.ebookRest.entity.Student;


@Component
public interface StudentDAO {

	public List<Student> getAllStudents();
	
	public void saveOrUpdate(Student s);
	
	public void deleteStudent(int id);
	
	public Student findStudentById(int id);
	
	
	
}
