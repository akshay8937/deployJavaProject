package com.app.propertymanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.propertymanagement.dao.IUserDao;
import com.app.propertymanagement.pojos.Buyer;
import com.app.propertymanagement.pojos.Seller;


@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController
{
	
	
	@Autowired
	private IUserDao dao; 
	 
	
	 public UserController() {
		
		System.out.println("in user controller");
	}
	 
	 
	 @GetMapping("/login")
		public String showLoginForm() {
			System.out.println("in show login form");
			return "/user/login";
		}
	 
	 
	 
	@GetMapping("/seller/{sid}")
	public ResponseEntity<?> getSellerBySId(@PathVariable Long sid) {
		System.out.println("in get  seller " + sid);
		return new ResponseEntity<Seller>(dao.findBysid(sid),HttpStatus.OK);
	}
		
	@GetMapping("/buyer/{bid}")
	public ResponseEntity<?> getBuyerByBId(@PathVariable Long bid) {
		System.out.println("in get  buyer " + bid);
		return new ResponseEntity<Buyer>(dao.findBybid(bid),HttpStatus.OK);
	
	}	
	
	@GetMapping("/deleteseller/{sid}")
	public ResponseEntity<?> deleteSellerBySId(@PathVariable Long sid) {
		System.out.println("in delete  seller " + sid);
		return new ResponseEntity<String>(dao.deleteBysid(sid),HttpStatus.OK);
	}
	
	@GetMapping("/deletebuyer/{bid}")
	public ResponseEntity<?> deleteBuyerBySId(@PathVariable Long bid) {
		System.out.println("in delete  buyer " + bid);
		return new ResponseEntity<String>(dao.deleteBybid(bid),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,String password, String role,Model map,
			RedirectAttributes flashMap, HttpSession hs)
	{
		System.out.println(email);
		System.out.println(password);
		System.out.println(role);
		
		if(role.contentEquals("seller")) 
		{ 
			Seller seller=dao.sellerValidation(email,password); 
			
			
		if(seller!=null) 
		{ 
			//System.out.println("login seller successful");
		
			hs.setAttribute("seller_dtls", seller);
			flashMap.addFlashAttribute("msg", "Login Successful");
			return "redirect:/seller/sellerDetails";
		}
		else { 
			//System.out.println("invalid seller");
			map.addAttribute("msg", "Invalid Login");
			return "/user/login";
			} 
		} 
	else
	{ 
		Buyer buyer=dao.buyerValidation(email, password);
		if(buyer!=null)
		{
		//System.out.println("login Buyer successful");
			hs.setAttribute("buyer_dtls", buyer);
			flashMap.addFlashAttribute("msg", "Login Successful");
		return "redirect:/buyer/buyerDetails";
		} 
		else
		{
		//System.out.println("invalid Buyer");
			map.addAttribute("msg", "Invalid Login");
			return "/user/login";
		} 
		
	}
	}
	
	@GetMapping("/sellerLogout")
	public String sellerLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) {
		System.out.println("in user logout");
		//copy session attr ---> model map
		map.addAttribute("s_dtls",hs.getAttribute("seller_dtls"));
		//set refresh hdr
		resp.setHeader("refresh", "2;url="+"/");
		//discard session
		hs.invalidate();
		return "/user/sellerLogout";
	}
	
	@GetMapping("/buyerLogout")
	public String buyerLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) {
		System.out.println("in user logout");
		//copy session attr ---> model map
		map.addAttribute("b_dtls",hs.getAttribute("buyer_dtls"));
		//set refresh hdr
		resp.setHeader("refresh", "2;url="+"/");
		//discard session
		hs.invalidate();
		return "/user/buyerLogout";
	}
	
	@GetMapping("/sellerRegistration")
	public String showRegistrationForm(Model map)
	{
		Seller s=new Seller();
		map.addAttribute("seller",s);

		return "/user/sellerRegistration";
	}
	
	@PostMapping("/sellerRegistration")
	public String sellerRegistration(@Valid Seller s, BindingResult result,RedirectAttributes map)
	{
		if(result.hasErrors())
		{
			System.out.println("P.L errs "+result);
			//in case of P.L errors --forward clnt to reg form
			return "/user/sellerRegistration";
		}
		else
		{
		Seller seller=dao.registrationSeller(s);
		if(seller!=null)
		{
			//System.out.println("registered successful");
			map.addFlashAttribute("msg","Registered Successful, Now You can login");
			return "redirect:/user/login";
		}
		else
		{
			//System.out.println("not registered");
			map.addFlashAttribute("msg"," Not Registered ,Please try Again");
			return "redirect:/user/login";
		}
		}
	}
	
	@GetMapping("/buyerRegistration")
	public String showRegistrationFormBuyer(Model map)
	{
		Buyer b=new Buyer();
		map.addAttribute("buyer", b);
		return "/user/buyerRegistration";
	}
	
	@PostMapping("/buyerRegistration")
	public String processBuyerRegistration(@Valid Buyer b,BindingResult result,RedirectAttributes map)
	{
		if(result.hasErrors())
		{
			System.out.println("P.L errs "+result);
			//in case of P.L errors --forward clnt to reg form
			return "/user/buyerRegistration";
		}
		else
		{
		Buyer buyer=dao.registrationBuyer(b);
		if(buyer!=null)
		{
			//System.out.println("registered successful buyer");
			map.addFlashAttribute("msg","Registered Successful, Now You can login");
			return "redirect:/user/login";
		}
		else
		{
			//System.out.println("not registered buyer");
			map.addFlashAttribute("msg"," Not Registered ,Please try Again");
			return "redirect:/user/login";	
			}
	}
	
	}	
}



 