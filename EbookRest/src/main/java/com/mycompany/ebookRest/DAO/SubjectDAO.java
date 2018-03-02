package com.mycompany.ebookRest.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompany.ebookRest.entity.Subject;

@Component
public interface SubjectDAO {

	List<Subject> getAllSubjects();
}
