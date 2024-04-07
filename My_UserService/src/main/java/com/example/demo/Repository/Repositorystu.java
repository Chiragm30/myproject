package com.example.demo.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.student.student;

@Repository
public interface Repositorystu extends JpaRepository<student ,Integer>{

	public Optional<student> findBysid(Integer sid);
 
}
