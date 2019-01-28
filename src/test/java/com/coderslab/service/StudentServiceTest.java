/**
 * 
 */
package com.coderslab.service;

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
@SpringBootTest
@ComponentScan(basePackages = {"com.coderslab.*"})
@Rollback(false)
public class StudentServiceTest {

	@Autowired StudentService service;

	@Test
	public void testSave() {
		Student student = new Student();
		student.setName("zubayer");
		service.save(student);
	}

	@Test 
	public void testGetAll() {
		List<Student> students = service.getAll();
		students.stream().forEach(s -> {
			System.out.println(s.toString());
		});
	}

	@Test
	public void testFindOne() {
		Student student = service.findById(new Long(3));
		System.out.println(student.toString());
	}

	@Test
	public void testFindByName() {
		Student student = service.findByName("zubayer");
		System.out.println(student.toString());
	}

	@Test
	public void testDelete() {
		service.deleteById(new Long(3));
	}
}
