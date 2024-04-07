package com.example.demo.Urepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.University;


@Repository
public interface RepositoryU extends JpaRepository<University, Integer>{

	public Optional<University> findByUid(Integer uid);

}
