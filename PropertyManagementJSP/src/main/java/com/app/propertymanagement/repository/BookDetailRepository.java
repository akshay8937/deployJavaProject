package com.app.propertymanagement.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.propertymanagement.pojos.BookDetail;
import com.app.propertymanagement.pojos.Seller;

@Repository
@Transactional
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {
	
	@Modifying
	@Query("update Property p set p.status = :status where p.propertyId = :id")
	public int updateStatusOfProperty(@Param("status") String status, 
	  @Param("id") Long id);
	
	
	@Query("select sellerId from Property p where p.propertyId=:pid")
	public Seller getSellerId(@Param("pid") Long id);

}
