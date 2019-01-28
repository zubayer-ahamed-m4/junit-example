package com.coderslab;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coderslab.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = {"com.coderslab.*"})
@Rollback(false)
@SpringBootTest
public class JunitExampleApplicationTests {

	@PersistenceContext
	EntityManager em;

	@Test
	@Transactional
	public void testSave() {
		Student student = new Student();
		student.setName("zubayer");
		em.persist(student);
	}

	@Test 
	public void testGetAll() {
		List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
		students.stream().forEach(s -> {
			System.out.println(s.toString());
		});
	}

	@Test
	public void testFindOne() {
		Student student = em.find(Student.class, 1);
		System.out.println(student.toString());
	}

	@Test
	public void testFindByName() {
		Student student = em.createQuery("SELECT s FROM Student s WHERE s.name=:name", Student.class)
							.setParameter("name", "zubayer")
							.getResultList()
							.stream()
							.findFirst()
							.orElse(null);
		System.out.println(student.toString());
	}

	@Test
	@Transactional
	public void testDelete() {
		em.createQuery("DELETE FROM Student s WHERE s.name=:name")
		.setParameter("name", "zubayer")
		.executeUpdate();
	}
}

