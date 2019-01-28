/**
 * 
 */
package com.coderslab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderslab.entity.Student;
import com.coderslab.repository.StudentRepository;

/**
 * @author zubayer
 *
 */
@Service
public class StudentService {

	@Autowired StudentRepository repo;

	public Student save(Student student) {
		return repo.save(student);
	}

	public List<Student> getAll(){
		return repo.findAll();
	}

	public Student findById(Long id) {
		return repo.findById(id).get();
	}

	public Student findByName(String name) {
		return repo.getByName(name);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}
}
