package com.dxc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dxc.service.UserService;
import com.dxc.model.User;



@Controller

public class IndexController {

	


	@Autowired
	UserService userServer;
	
	
	@RequestMapping(value = "login",  method = RequestMethod.GET)
	public String createManual(ModelMap m){

		User user = new User();
		m.put("user", user);

		
		
		return "login";
	}
	
	
	@RequestMapping(value = "login",  method = RequestMethod.POST)
	public String loginUser(ModelMap modelMap, @ModelAttribute(value = "user") User user){
	
		
		
		modelMap.put("user", user);
		
		
		
		return "welcome";
	}
	
	@RequestMapping("/signup")
	public String registerUser(ModelMap modelMap, @ModelAttribute(value = "user") User user){
		
		userServer.saveOrUpdate(user);
		
		return "login";
	}
	
	
	

}
