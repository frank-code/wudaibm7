package com.mybatis3.services;

import java.util.*;
import org.junit.*;
import com.mybatis3.domain.Student;

public class StudentServiceTest {
	private static StudentService studentService;
	
	int id = 3;

	@BeforeClass
	public static void setup() {
		studentService = new StudentService();
	}

	@AfterClass
	public static void teardown() {
		studentService = null;
	}

//	@Test
	public void testFindAllStudents() {
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		for (Student student : students) {
			System.out.println(student.getName());
		}
	}

//	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
		System.out.println(student.getName());
	}

	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setStudId(id);
		student.setName("student" + id);
		student.setEmail("student" + id + "@qq.com");
		student.setDob(new Date());
		studentService.createStudent(student);
		Student newStudent = studentService.findStudentById(id);
		Assert.assertNotNull(newStudent);
	}
}