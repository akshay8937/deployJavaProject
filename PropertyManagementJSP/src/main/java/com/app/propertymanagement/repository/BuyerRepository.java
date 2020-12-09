package com.app.propertymanagement.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.propertymanagement.pojos.Buyer;
import com.app.propertymanagement.pojos.Seller;



@Repository
@Transactional
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
	
	public Buyer findBybid(Long id);
	
	public String deleteBybid(Long id);
	/*
	 * @Query("select b from Buyer b where b.bid=:bid") public Buyer
	 * seeUploadProperties(@Param("bid") Long id);
	 */
	
	@Query("select b from Buyer b where b.email=:em and b.password=:pass")
	public Buyer validateBuyer(@Param("em") String email, @Param("pass") String pass);
	

}
