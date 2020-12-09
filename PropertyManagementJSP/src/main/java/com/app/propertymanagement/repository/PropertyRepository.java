package com.app.propertymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.propertymanagement.pojos.Property;
import com.app.propertymanagement.pojos.Seller;



@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
	
	@Query("select p from Property p where p.sellerId=:sid")
	public List<Property> seeUploadProperties(@Param("sid") Seller sid);
	
	@Query("select p from Property p where p.status=:s")
	public List<Property> seeAllProperties(@Param("s") String s);
	
	
	@Query("select images from Property p where p.propertyId=:pid")
	public byte[] getImage(@Param("pid") Long id);
	
	
	@Query("select p from Property p where p.propertyId in(select bookedProperty from BookDetail b where b.seller_Id=:sid)")
	public List<Property> getBookedProperty(@Param("sid") Seller sid);
}
