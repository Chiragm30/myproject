package com.microservices.ui.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.ui.Entity.Employee;


@Repository
public interface userRepository extends JpaRepository<Employee, Long>{

//	public Optional<Employee> findByEmployeeId(Integer employeeId);

	//public void deleteByEmployeeId(Integer employeeId);

//	public Employee findByfirstName(String firstName);
}
