package com.app.propertymanagement.dao;

import com.app.propertymanagement.pojos.Buyer;
import com.app.propertymanagement.pojos.Property;

public interface IBuyerDao {
	
  public Buyer getBuyerDetail(Property id); 	

}
