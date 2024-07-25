package com.org.SpringDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.SpringDemo.model.EmployeeModel;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel, Long> {

	
	@Query(value = " Select * from employee where id=:id",nativeQuery = true)
	Optional<EmployeeModel> findByIdEmp(Long id);

}
