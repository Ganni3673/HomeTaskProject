package com.org.SpringDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.SpringDemo.model.EmailModel;

@Repository
public interface EmailRepo extends JpaRepository<EmailModel, Integer> {

	
	@Query(value = " Select * from email where id=:id",nativeQuery = true)
	Optional<EmailModel> findByIdEmail(int id);

}
