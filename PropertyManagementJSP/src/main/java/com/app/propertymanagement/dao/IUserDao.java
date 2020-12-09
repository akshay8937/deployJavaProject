package com.app.propertymanagement.dao;



import com.app.propertymanagement.pojos.Buyer;
import com.app.propertymanagement.pojos.Seller;


public interface IUserDao {
	
	public Seller sellerValidation(String email,String pass);
	
	public Buyer buyerValidation(String email,String pass);
	
	public Seller registrationSeller(Seller s);
	
	public Buyer registrationBuyer(Buyer b);
	
	public Seller findBysid(Long id);
	
	public Buyer findBybid(Long id);
	
	public String deleteBysid(Long id);
	
	public String deleteBybid(Long id);

}
