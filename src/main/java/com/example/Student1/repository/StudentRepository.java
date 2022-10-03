package com.example.Student1.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Student1.entity.StudentEntity;
@Repository

public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{
	public List<StudentEntity> findAll();

	//public Optional<StudentEntity> updateById(int rollNo);
	
}

