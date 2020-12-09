package com.app.propertymanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.propertymanagement.pojos.BookDetail;
import com.app.propertymanagement.pojos.Buyer;
import com.app.propertymanagement.pojos.Property;
import com.app.propertymanagement.repository.BookDetailRepository;
import com.app.propertymanagement.repository.SellerRepository;

@Service
public class BuyerDaoImpl implements IBuyerDao {
	
	@Autowired
	SellerRepository Srepository;

	@Override
	public Buyer getBuyerDetail(Property id) {
		Buyer buyer=Srepository.buyerDetail(id);
		return buyer;
	}

}
