package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface Repositoryemp extends JpaRepository<Employee, Integer> 
{
   public Optional<Employee> findByeid(Integer eid);
}
