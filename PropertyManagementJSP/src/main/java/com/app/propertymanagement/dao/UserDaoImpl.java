package com.app.propertymanagement.dao;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.propertymanagement.pojos.Buyer;
import com.app.propertymanagement.pojos.Seller;
import com.app.propertymanagement.repository.BuyerRepository;
import com.app.propertymanagement.repository.SellerRepository;

@Service
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	SellerRepository Srepository;
	@Autowired
	BuyerRepository Brepository;

	@Override

	public Seller sellerValidation(String email,String pass) {
		
		Seller s=Srepository.validateSeller(email, pass);
		return s;
	}

	
	  @Override 
	  public Buyer buyerValidation(String email,String pass)
	  {
		  Buyer b=Brepository.validateBuyer(email, pass);
		  return b;
	  }
	 
	
	@Override
	public Seller findBysid(Long id)
	{
		Seller seller=Srepository.findBysid(id);
		return seller;
	}


	@Override
	public Seller registrationSeller(Seller s) {
		Seller seller=Srepository.save(s);
		return seller;
	}


	@Override
	public Buyer registrationBuyer(Buyer b) {
	Buyer buyer=Brepository.save(b);
		return buyer;
	}


	@Override
	public Buyer findBybid(Long id) {
		Buyer buyer=Brepository.findBybid(id);
		return buyer;
	}


	@Override
	public String deleteBysid(Long id) {
		Srepository.deleteBysid(id);
		return "Seller deleted Successfully";
	}


	@Override
	public String deleteBybid(Long id) {
		Brepository.deleteBybid(id);
		return "Buyer deleted Successfully";
	}
	
	

}
