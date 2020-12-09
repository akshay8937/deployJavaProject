package com.app.propertymanagement.dao;

import com.app.propertymanagement.pojos.BookDetail;
import com.app.propertymanagement.pojos.Seller;

public interface IBookDao {
	
	public int updateStatus(String s,Long id);
	
	public BookDetail insertBookDetail(BookDetail b);
	
	public Seller getSellerId(Long id);
}
