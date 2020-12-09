package com.app.propertymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.propertymanagement.pojos.Property;
import com.app.propertymanagement.pojos.Seller;
import com.app.propertymanagement.repository.PropertyRepository;


@Service
public class PropertyDaoImpl implements IPropertyDao{

	@Autowired
	PropertyRepository Prepository;
	
	@Override
	public Property addProperty(Property p) {
	Property pro=Prepository.save(p);
		return pro;
	}

	@Override
	public String deleteProperty(Long id) {
		Prepository.deleteById(id);
		
		return "Property deleted Successfully";
	}

	@Override
	public List<Property> seeUploadProperties(Seller id) {
	
		List<Property> property = new ArrayList<Property>();
		property=Prepository.seeUploadProperties(id);
		return property;
	}

	@Override
	public byte[] getImage(Long id) {
		byte[] img= Prepository.getImage(id);
		return img;
	}

	@Override
	public List<Property> seeAllProperties(String s) {
		List<Property> property =new ArrayList<>();
		property=Prepository.seeAllProperties(s);
		return property;
	}

	@Override
	public List<Property> getBookedProperty(Seller id) {
		List<Property> pro=new ArrayList<>();
		pro=Prepository.getBookedProperty(id);
		return pro;
	}

}
