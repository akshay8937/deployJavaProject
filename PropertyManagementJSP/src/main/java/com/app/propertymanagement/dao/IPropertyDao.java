package com.app.propertymanagement.dao;

import java.util.List;

import com.app.propertymanagement.pojos.Property;
import com.app.propertymanagement.pojos.Seller;

public interface IPropertyDao {
	
	public Property addProperty(Property p);
	
	public List<Property> seeUploadProperties(Seller id);
	
	public List<Property> seeAllProperties(String s);
	
	public byte[] getImage(Long id);
	
	public String deleteProperty(Long id);
	
	public List<Property> getBookedProperty(Seller id); 

}
