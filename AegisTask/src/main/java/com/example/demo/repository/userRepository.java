package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository
public interface userRepository  extends JpaRepository<User,Integer >{

    public User save(User user) ;
	
	

}
