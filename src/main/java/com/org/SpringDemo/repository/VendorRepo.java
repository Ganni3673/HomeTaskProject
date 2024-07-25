package com.org.SpringDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.SpringDemo.model.VendorModel;

@Repository
public interface VendorRepo extends JpaRepository<VendorModel, Integer> {

	@Query(value = "select * from Vendor where id=:id",nativeQuery = true)
	Optional<VendorModel> findByIdVendor(int id);

}
