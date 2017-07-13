package com.ShoesKart.ShoesKartFrontend.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ShoesKart.ShoesKartBackend.Dao.CartDao;
import com.ShoesKart.ShoesKartBackend.Dao.CategoryDao;
import com.ShoesKart.ShoesKartBackend.Dao.ProductDao;
import com.ShoesKart.ShoesKartBackend.Dao.SupplierDao;
import com.ShoesKart.ShoesKartBackend.model.Cart;
import com.ShoesKart.ShoesKartBackend.model.Category;
import com.ShoesKart.ShoesKartBackend.model.Product;
import com.ShoesKart.ShoesKartBackend.model.Supplier;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	CategoryDao categoryDao;

	@Autowired
	SupplierDao supplierDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	CartDao cartDao;
	@RequestMapping("/contactus")
	public String viewContact(){
		
		return "usercontact";
	}
	
	@RequestMapping("/aboutus")
	public String vieeweAbout(){
		
		return "userabout";
	}
	@RequestMapping("/product")
	public String showProduct(Model m) {

		List<Product> products = productDao.getAll();
		m.addAttribute("prodList", products);

		return "userproduct";
	}

	@RequestMapping("/home")
	public String showUserHome() {
		return "redirect:/login_success";
	}

	@RequestMapping("/product/view/{prodId}")
	public String viewProduct(@PathVariable("prodId") int prodId, Model m) {
		m.addAttribute("product", productDao.getById(prodId));

		return "userproductfocus";
	}

	@RequestMapping("/product/addtocart/{prodid}")
	public String addCart(@PathVariable("prodid") int prodid,// @RequestParam("quantity") int quantity,
			HttpSession session, Model m) {

		Product product = productDao.getById(prodid);

			int cartid = 0; int maxcartid = 0;
			Cart cart = new Cart();
			String username = (String) session.getAttribute("username");
			List<Cart> firstcart=cartDao.getAll(username);
			List<Cart> maxcartlist=cartDao.getMaxcartid();
			if(firstcart.size() != 0){
				cartid = firstcart.get(firstcart.size() - 1).getCartid();
				cart.setCartid(cartid);
			}
			else{
				if(maxcartlist.size() != 0){
					maxcartid = maxcartlist.get(maxcartlist.size() - 1).getCartid() + 1;
					
				}
				else{
					maxcartid = 1;
				}
				cart.setCartid(maxcartid);
			}
			//cart.setQuantity(quantity);
			cart.setStatus("N");
			cart.setUsername(username);
			cart.setProdid(prodid);

			cart.setProdname(product.getName());
			cart.setPrice(product.getPrice());

			cartDao.insertUpdate(cart);

			return "redirect:/user/cart";
		
		
		
	}

	@RequestMapping("/product/addtocart2/{prodid}")
	public String addCart2(@PathVariable("prodid") int prodid, @RequestParam("quantity") int quantity,
			HttpSession session, Model m) {

		Product product = productDao.getById(prodid);
		if(quantity <= product.getQuantity()){
			int cartid = 0; int maxcartid = 0;
			Cart cart = new Cart();
			String username = (String) session.getAttribute("username");
			List<Cart> firstcart=cartDao.getAll(username);
			List<Cart> maxcartlist=cartDao.getMaxcartid();
			if(firstcart.size() != 0){
				cartid = firstcart.get(firstcart.size() - 1).getCartid();
				cart.setCartid(cartid);
			}
			else{
				if(maxcartlist.size() != 0){
					maxcartid = maxcartlist.get(maxcartlist.size() - 1).getCartid() + 1;
					
				}
				else{
					maxcartid = 1;
				}
				cart.setCartid(maxcartid);
			}
			cart.setQuantity(quantity);
			cart.setStatus("N");
			cart.setUsername(username);
			cart.setProdid(prodid);

			cart.setProdname(product.getName());
			cart.setPrice(product.getPrice());

			cartDao.insertUpdate(cart);

			return "redirect:/user/cart";
		}
		else{
			return "quantity";
		}

	}

	
	@RequestMapping("/cart")
	public String viewCart(Model m, HttpSession session) {

		String username = (String) session.getAttribute("username");

		List<Cart> cartList = cartDao.getAll(username);
		m.addAttribute("cartList", cartList);

		return "cart";
	}

	@RequestMapping("/update/{citemid}")
	public String updateCart(@PathVariable("citemid") int citemid, @RequestParam("quantity") int quantity,
			HttpSession session, Model m) {

		//if (quantity < 0) {

			Cart cart = (Cart) cartDao.getById(citemid);
			Product product = productDao.getById(cart.getProdid());
			if(quantity <= product.getQuantity())
			{
			cart.setQuantity(quantity);
			cartDao.insertUpdate(cart);

			String username = (String) session.getAttribute("username");

			List<Cart> cartlist = cartDao.getAll(username);
			m.addAttribute("cartlist", cartlist);

			return "redirect:/user/cart";
			}
			else{
				return "quantity";
			}
			

	//	} else {
	//		return "quantity";
	//	}
	}
	@RequestMapping("/delete/{citemid}")
	public String deleteCart(@PathVariable("citemid") int citemid,HttpSession session,Model m)
	{
		

		

		
		Cart cart=(Cart)cartDao.getById(citemid);
		
		cartDao.delete(cart);
		
	String username=(String) session.getAttribute("username");
		
		List<Cart> cartlist=cartDao.getAll(username);
		m.addAttribute("cartlist",cartlist);
		
		
		
		return "redirect:/user/cart";
		
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model m,HttpSession session)
	{
		
		String username=(String) session.getAttribute("username");
		List<Cart> cartList=cartDao.getAll(username);
		
		int grandtotal=0;
		
	for(Cart cart:cartList)
	{
		grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
		//cart.setStatus("Y");
		//cartDao.insertUpdate(cart);
	}
		
		
		
		m.addAttribute("grandtotal",grandtotal);
		m.addAttribute("cartList",cartList);
		
		return "/checkout";
	}
	
	@RequestMapping("/payment")
	public String paymentProcess(Model m, HttpSession session){
		String username=(String) session.getAttribute("username");
		List<Cart> cartList=cartDao.getAll(username);
		for(Cart cart: cartList){
			cart.setStatus("Y");
			cartDao.insertUpdate(cart);
		}
		return "thankyou";
	}

}
