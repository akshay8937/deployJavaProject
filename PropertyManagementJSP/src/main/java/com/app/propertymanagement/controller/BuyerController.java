package com.app.propertymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.propertymanagement.dao.IBookDao;
import com.app.propertymanagement.dao.IPropertyDao;
import com.app.propertymanagement.pojos.BookDetail;
import com.app.propertymanagement.pojos.Buyer;
import com.app.propertymanagement.pojos.Property;
import com.app.propertymanagement.pojos.Seller;

@Controller
@RequestMapping("/buyer")
public class BuyerController {
	@Autowired
	IPropertyDao dao;
	@Autowired
	IBookDao Bookdao;
	
	public BuyerController() {
		System.out.println("in buyer controller ctor");
	}
	//request handling method to display vendor dtls
	@GetMapping("/buyerDetails")
	public String showBuyerDetails(Model map)
	{
		System.out.println("in show buyer dtls");
		String s="available";
		List<Property> property =new ArrayList<>();
		property=dao.seeAllProperties(s);
		System.out.println("property is"+property);
		map.addAttribute("property_list", dao.seeAllProperties(s));
		return "/buyer/buyerDetails";
	}
	
	@GetMapping("/bookConfirmed")
	public String bookConfirmed(@RequestParam("pid") Long pid,@RequestParam("bid") Long bid,HttpServletRequest request,HttpServletResponse resp)
	{
		Seller seller=Bookdao.getSellerId(pid);
		
		Property p= new Property();
		p.setPropertyId(pid);
		
		Buyer b=new Buyer();
		b.setBid(bid);
		
		BookDetail book=new BookDetail();
		book.setBuyerId(b);
		book.setSeller_Id(seller);
		book.setBookedProperty(p);
		
		Bookdao.insertBookDetail(book);
		
		String s="unavailable";
		int a=Bookdao.updateStatus(s, pid);
		System.out.println(a);
		resp.setHeader("refresh", "5;url="+"/buyer/buyerDetails");
		return "/book/bookConfirmed";
	}
}