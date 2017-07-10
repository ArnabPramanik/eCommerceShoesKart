package com.ShoesKart.ShoesKartFrontend.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ShoesKart.ShoesKartBackend.Dao.ProductDao;
import com.ShoesKart.ShoesKartBackend.Dao.UserDao;
import com.ShoesKart.ShoesKartBackend.model.Product;
import com.ShoesKart.ShoesKartBackend.model.User;

@Controller
public class IndexController {
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
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
		List <String> role_list = new ArrayList<String>();
		role_list.add("administrator");
		role_list.add("user");
		m.addAttribute("role_list",role_list);
		m.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user){
	    userDao.insertUpdate(user);
		return "index";
	}
	@RequestMapping("/login")
	public String showSignIn(){
		
		return "login";
		
	}
	
	@RequestMapping("/product")
	public String showProduct(Model m){

		List <Product> products = productDao.getAll();
		m.addAttribute("prodList", products);

		return "userproduct";
	}
/*	@RequestMapping(value = "/perform_login", method = RequestMethod.POST)
	public String logIn(@RequestParam("username")String username, @RequestParam("password")String password){
		User user = userDao.getById(username);
		try{
		 if(user.getPassword().equals(password)){
			System.out.println("login success");
			return "redirect:/login_success";
		 }
		else{
			System.out.println("login failed");
		}
		}
		catch(Exception e){}
		return "index";
	}*/
	
	@RequestMapping("/loginfail")
	public String loginfail(){
		
		return "index";
	}
	@RequestMapping("/login_success")
	public String loginSuccess(HttpSession session){
		System.out.println("loded successfully");
		

		   String username= SecurityContextHolder.getContext().getAuthentication().getName();

		   session.setAttribute("username",username);
		   

			@SuppressWarnings("unchecked")
			Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		  for(GrantedAuthority role:authorities)
			{
			  System.out.println("Role:"+role.getAuthority()+"username"+username);
				
			  
			if(role.getAuthority().equals("administrator"))
			{
				
			return "adminhome";
			}
			else
			{
			return "userhome";
			}
			}
		return "index";
	}
	@RequestMapping("/product/view/{prodId}")
	public String viewProduct(@PathVariable("prodId") int prodId, Model m) {
		m.addAttribute("product", productDao.getById(prodId));

		return "productfocus";
	}
	
	
}
