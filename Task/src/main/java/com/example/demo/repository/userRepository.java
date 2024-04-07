package com.example.demo.repository;

import java.util.Optional;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository
public interface userRepository extends JpaRepository<User,Integer>
{
  Optional<User> findByUsername(String username);
}
