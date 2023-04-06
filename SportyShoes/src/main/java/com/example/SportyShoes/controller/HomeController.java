package com.example.SportyShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SportyShoes.dao.AdminRepository;
import com.example.SportyShoes.dao.ProductRepository;
import com.example.SportyShoes.dao.PurchaseReportRepository;
import com.example.SportyShoes.dao.Repository;
import com.example.SportyShoes.dao.UserRepository;
import com.example.SportyShoes.model.Admin;

@Controller
public class HomeController {
	
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	UserRepository  userRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	PurchaseReportRepository purchaseReportRepository;
	@Autowired
	Repository repository;
	
	@RequestMapping("/")
	public String showHome() {
		return "Home";
	}
	
	@RequestMapping(value="adminLogin",method = RequestMethod.GET)
	public String adminLoginPage() {
		return "AdminLogin";
	}
	
	@RequestMapping(value = "forgotPassword",method=RequestMethod.GET)
	public String forgotPassword() {
		return "ForgotPassword";
	}
	
	@RequestMapping(value="adminForgotPassword",method=RequestMethod.POST)
	public String adminForgotPasswordPage(@RequestParam("email")String email, @RequestParam("password")String password,ModelMap map) {
		if(repository.forgotPassword(email, password))
			map.addAttribute("message","Password Updated");
		else
			map.addAttribute("message","Invalid Details");
		return "ForgotPassword";
	}
	
	@RequestMapping(value="adminPage",method=RequestMethod.POST)
	public String adminPage(@RequestParam("email")String email, @RequestParam("password")String password,ModelMap map) {
		
		if(adminRepository.verifyAdmin(new Admin(email,password))) {
			return "AdminPage";
		}
		else
		{
			map.addAttribute("message","Invalid Details");
			return "AdminLogin";
		}		
	}
	
	@RequestMapping(value="user",method=RequestMethod.GET)
	public String getAllUsers(ModelMap map) {
		map.addAttribute("useList",userRepository.getAllUsers());
		return "User";
	}
	
	@RequestMapping(value="searchUser",method=RequestMethod.GET)
	public String searchUser(@RequestParam("email")String email,ModelMap map) {
		map.addAttribute("userList",userRepository.searchUser(email));
		return "User";
	}
	
	
	@RequestMapping(value="product",method=RequestMethod.GET)
	public String getAllProducts(ModelMap map) {
		
		map.addAttribute("productList",productRepository.getAllProducts());
		return "Product";
		
	}
	
	@RequestMapping(value="deleteProduct",method=RequestMethod.GET)
	public String deleteProduct(@RequestParam("id")int id,ModelMap map) {
		
		if(productRepository.deleteProduct(id))
			map.addAttribute("message","Product Deleted Successfully");
		else
			map.addAttribute("message","Try after few minutes");
		
		map.addAttribute("productList",productRepository.getAllProducts());
		
		return "Product";
		
	}
	
	@RequestMapping(value="purchaseReport",method=RequestMethod.GET)
	public String getRport(ModelMap map) {
		
		map.addAttribute("report",purchaseReportRepository.getReport());
		return "PurchaseReport";
		
	}
}
