package com.ShoesKart.ShoesKartFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ShoesKart.ShoesKartBackend.Dao.UserDao;
import com.ShoesKart.ShoesKartBackend.model.User;

@Controller
public class IndexController {
	@Autowired
	UserDao userDao;
	@RequestMapping("/")
	public String showIndex(Model m){
		
		return "index";
	}
	
	@RequestMapping("/index")
	public String showIndex2(Model m){
		
		return "index";
	}
	@RequestMapping("/signup")
	public String showSignUp(Model m){
		m.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user){
	    userDao.insertUpdate(user);
		return "index";
	}
	@RequestMapping("/signin")
	public String showSignIn(){
		
		return "login";
		
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logIn(@RequestParam("username")String username, @RequestParam("password")String password){
		User user = userDao.getById(username);
		try{
		 if(user.getPassword().equals(password)){
			System.out.println("login success");
		 }
		else{
			System.out.println("login failed");
		}
		}
		catch(Exception e){}
		return "index";
	}
}
