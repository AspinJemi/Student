package com.example.Student1.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import com.example.Student1.entity.StudentEntity;
import com.example.Student1.repository.StudentRepository;
@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	
	public StudentEntity student(StudentEntity student) {
		return repository.save(student);
	}
	
	public List<StudentEntity> saveStudent(List<StudentEntity> student) {
		return repository.saveAll(student);
	}
	
	public StudentEntity getStudentByRollNo(int rollNo) {
		return repository.findById(rollNo).orElse(null);
	}
	
	
	public List<StudentEntity> getStudent() {
		return repository.findAll();
	}

	public  String  deleteStudentByRollNo(int rollNo) {
		repository.deleteById(rollNo);
		return "rollNo Removed"+rollNo;
	}

	public String updateStudentEntity(int rollNo,StudentEntity student){
        StudentEntity student1=repository.findById(rollNo).orElse(null);
        if((student1!=null)&&(student1.getRollNo() == rollNo)){
        	student1.setAge(student.getAge());
        	student1.setFirstname(student.getFirstname());
        	student1.setLastname(student.getLastname());
        	student1.setGender(student.getGender());
        	student1.setEmail(student.getEmail());
        	student1.setPhoneNo(student.getPhoneNo());
        	student1.setPassword(student.getPassword());
        	student1.setQualification(student.getQualification());
            repository.save(student1);
            //return client;
        }
        else {
            return "user id not fond.!";
        }
//            throw new exception_class("error message");
        //return client;
        return "Done.!";

    }
	

	
	
	
}
