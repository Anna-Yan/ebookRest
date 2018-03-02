package com.mycompany.ebookRest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.ebookRest.DAO.StudentDAO;
import com.mycompany.ebookRest.entity.Student;


@RestController
public class Controller {

	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping(value="/getStudents/", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<Student> getStudents()
	{
		System.out.println("Mesageeee:In Controller: getStudentsList ");
		List<Student> list = null;
			try {
				list=studentDAO.getAllStudents();
				//list.add(new Student());	
			} catch (Exception e) {
				System.out.println("Failed to get Users list");
			}
			
			return list;	
	}
	
	@RequestMapping(value="/addStudent/", method=RequestMethod.POST)
	public @ResponseBody Student addStudent(@RequestBody Student student) {
		System.out.println("Mesageeee:In Controller: addStudent ");
		try {
			studentDAO.saveOrUpdate(student);
		} catch (Exception e) {
			System.out.println("Failed to save Student");
		}
	
		return student;
	}
	
	 @RequestMapping(value="/updateStudent/{id}", method=RequestMethod.PUT)
	 public @ResponseBody Student update(@PathVariable("id") int id, @RequestBody Student student){
	  System.out.println("Mesageeee:In Controller: updateStudent ");
	  student.setId(id);
	  
		try {
			studentDAO.saveOrUpdate(student);
		} catch (Exception e) {
			System.out.println("Failed to Update Student");
		}
	  return student;
	 }
	
	 @RequestMapping(value="/deleteStudent/{id}", method=RequestMethod.DELETE)
	 public @ResponseBody Student delete(@PathVariable("id") int id){
	  System.out.println("Mesageeee:In Controller: deleteStudent ");
	  Student student = studentDAO.findStudentById(id);
		try {
			  studentDAO.deleteStudent(id);
		} catch (Exception e) {
			System.out.println("Failed to delete Student");
		}	  
	  return student;
	 }
}
