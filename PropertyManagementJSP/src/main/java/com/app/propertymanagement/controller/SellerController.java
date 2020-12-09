package com.app.propertymanagement.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.propertymanagement.dao.IBuyerDao;
import com.app.propertymanagement.dao.IPropertyDao;
import com.app.propertymanagement.pojos.Buyer;
import com.app.propertymanagement.pojos.Property;
import com.app.propertymanagement.pojos.Seller;

@Controller
@RequestMapping("/seller")
public class SellerController{
	
	@Autowired
	IPropertyDao dao;
	@Autowired
	IBuyerDao BuyerDao;
	
	Seller s = new Seller();
	
	public SellerController() {
		System.out.println("in seller controller ctor");
	}
	//request handling method to display vendor dtls
	@GetMapping("/sellerDetails")
	public String showSellerDetails()
	{
		System.out.println("in show seller dtls");
		return "/seller/sellerDetails";
	}
	@GetMapping("/sellProperty")
	public String showPropertyForm(@RequestParam("sid") Long sid)
	{
		System.out.println(sid);
		s.setSid(sid);
		
		System.out.println("in seller show property form");
		return "/seller/sellProperty";
	}
	
	@PostMapping("/sellProperty")
	public String processPropertyForm(@RequestParam("propType") String propType,
			@RequestParam("images") MultipartFile contents,@RequestParam("city") String city,
			@RequestParam("address") String address,@RequestParam("description") String description,
			@RequestParam("price") int price,RedirectAttributes map)
	{
		
		Property pro=new Property();
		pro.setAddress(address);
		pro.setCity(city);
		pro.setDescription(description);
		try {
			pro.setImages(contents.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hlw from");
		
		
		pro.setPrice(price);
		pro.setPropType(propType);
		
		System.out.println(s.getSid());
		pro.setSellerId(s);
		System.out.println(pro);
		
		
		Property property=dao.addProperty(pro);
		
		if(property!=null)
		{
			//System.out.println("registered successful");
			return "redirect:/seller/showProperty?sid="+s.getSid();
		}
		else
		{
			//System.out.println("not registered");
			map.addFlashAttribute("msg"," Not Add Property ,Please try Again");
			return "redirect:/seller/sellProperty";
		}
		
	}
	
	@GetMapping("/showProperty")
	public String showAllProperty(Model map,@RequestParam("sid") Seller id)
	{
		
		System.out.println("in show v list");
		System.out.println(id);
		List<Property> property=dao.seeUploadProperties(id);
		//List<Property> pro = new ArrayList<>();
		/*
		 * for(Property p: property) { byte[] encodeBase64 =
		 * Base64.getEncoder().encode(p.getImages()); String base64Encoded = new
		 * String(encodeBase64, "UTF-8"); mav.addObject("userImage", base64Encoded );
		 * p.setImages(image);
		 * 
		 * 
		 * }
		 */
		System.out.println("property is"+property);
		map.addAttribute("property_list", dao.seeUploadProperties(id));
		return "/seller/showProperty";
	}
	
	
	@GetMapping("/deleteProperty")
	public String showDeletePropertyForm()
	{
	
		System.out.println("in seller delete property form");
		return "/seller/deleteProperty";
	}
	
	@PostMapping("/deleteProperty")
	public String processDeletePropertyForm(@RequestParam("id") Long id)
	{
		dao.deleteProperty(id);
		System.out.println("in seller process delete property form");
		return "redirect:/seller/showProperty?sid="+s.getSid();
	}
	
	@GetMapping("/bookedProperty")
	public String bookedProperty(Model map,@RequestParam("sid") Seller id)
	{
		System.out.println("in booked Property list");
		System.out.println(id);
		List<Property> property=dao.getBookedProperty(id);
		
		System.out.println("property is"+property);
		map.addAttribute("property_list", dao.getBookedProperty(id));
		
		return "/seller/bookedProperty";
	}
	
	@GetMapping("/bookBuyerDetails")
	public String bookBuyerDetails(@RequestParam("pid") Property pid,Model map)
	{
		System.out.println("in book Buyer details");
		Buyer b=BuyerDao.getBuyerDetail(pid);
		System.out.println(b);
		map.addAttribute("buyer_dtls", b);
		return "/seller/bookBuyerDetails";
	}
	
}
