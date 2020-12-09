package com.app.propertymanagement.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.propertymanagement.dao.IPropertyDao;

@Controller
@RequestMapping("/myImage")
public class imageController {

@Autowired
IPropertyDao dao;

public imageController() {
	// TODO Auto-generated constructor stub
	System.out.println("in image controller");
}
@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
  public void showImage(@RequestParam("id") Long id, HttpServletResponse response,HttpServletRequest request) 
          throws ServletException, IOException{
	System.out.println("in image control");

    //Item item = itemService.get(itemId); 
	System.out.println(dao.getImage(id));
    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
    response.getOutputStream().write(dao.getImage(id));


    response.getOutputStream().close();
    
}
}