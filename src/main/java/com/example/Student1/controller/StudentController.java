package com.example.Student1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student1.entity.StudentEntity;
import com.example.Student1.service.StudentService;
//import com.example.Student1.repository.StudentRepository;
import java.util.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
	@Autowired
	
	private StudentService service;
	@PostMapping("/addStudent")
	public StudentEntity addStudent(@RequestBody StudentEntity student) {
		System.out.println("firstname:"+student.getFirstname());
		return service.student(student);
	}
	
	@PostMapping("/addStudents")
	public List<StudentEntity> addAllStudent(@RequestBody List<StudentEntity> student) {
		return service.saveStudent(student);
	}
	
	@GetMapping("/getStudent")
	public List<StudentEntity> findAllStudent() {
		return service.getStudent();
	}
	
   @GetMapping("/getStudent/{rollNo}")
	public StudentEntity findStudentByRollNo(@PathVariable int rollNo) {
		return service.getStudentByRollNo(rollNo);
	}
   @DeleteMapping("/deleteByRollNo/{rollNo}")
   public String deleteBYRollNo(@PathVariable int rollNo) {
	   return service.deleteStudentByRollNo(rollNo);
   }
   @PutMapping("/student/{rollNo}/update")
   public String updateStudentEntity(@PathVariable String rollNo,@RequestBody StudentEntity student){
       //StudentEntity student;
       String s1;
       //client1= clientService.updateClient(Integer.parseInt(id),client);
       s1= service.updateStudentEntity(Integer.parseInt(rollNo),student);
       return s1;

   }

}


