/**
 * 
 */
package com.coderslab.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coderslab.entity.Student;

/**
 * @author zubayer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = {"com.coderslab.*"})
@Rollback(false)
@SpringBootTest
public class StudentRepositoryTest {

	@Autowired StudentRepository repo;

	@Test
	public void testSave() {
		Student student = new Student();
		student.setName("zubayer");
		repo.save(student);
	}

	@Test 
	public void testGetAll() {
		List<Student> students = repo.findAll();
		students.stream().forEach(s -> {
			System.out.println(s.toString());
		});
	}

	@Test
	public void testFindOne() {
		Student student = repo.findById(new Long(2)).get();
		System.out.println(student.toString());
	}

	@Test
	public void testFindByName() {
		Student student = repo.getByName("zubayer");
		System.out.println(student.toString());
	}

	@Test
	public void testDelete() {
		repo.deleteById(new Long(2));
	}
}
