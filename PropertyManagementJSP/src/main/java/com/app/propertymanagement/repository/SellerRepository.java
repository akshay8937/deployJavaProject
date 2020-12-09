package com.app.propertymanagement.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.propertymanagement.pojos.Buyer;
import com.app.propertymanagement.pojos.Property;
import com.app.propertymanagement.pojos.Seller;


@Repository
@Transactional
public interface SellerRepository extends JpaRepository<Seller, Long> {
	
	public Seller findBysid(Long id);
	
	public String deleteBysid(Long id);
	

	@Query("select s from Seller s where s.email=:em and s.password=:pass")
	public Seller validateSeller(@Param("em") String email, @Param("pass") String pass);
	
	@Query("select b from Buyer b where b.bid in(select buyerId from BookDetail book where book.bookedProperty=:pid)")
	public Buyer buyerDetail(@Param("pid") Property id);
	
	
}
