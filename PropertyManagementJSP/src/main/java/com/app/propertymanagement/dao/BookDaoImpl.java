package com.app.propertymanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.propertymanagement.pojos.BookDetail;
import com.app.propertymanagement.pojos.Seller;
import com.app.propertymanagement.repository.BookDetailRepository;

@Service
public class BookDaoImpl implements IBookDao {
	
	@Autowired
	BookDetailRepository Brepository;

	@Override
	public int updateStatus(String s, Long id) {
	int a=Brepository.updateStatusOfProperty(s, id);
		return a;
	}

	@Override
	public BookDetail insertBookDetail(BookDetail b) {
		BookDetail book=Brepository.save(b);
		return book;
	}

	@Override
	public Seller getSellerId(Long id) {
	Seller s=Brepository.getSellerId(id);
		return s;
	}

}
