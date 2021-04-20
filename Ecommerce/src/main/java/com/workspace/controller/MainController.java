package com.workspace.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.workspace.model.Product;
import com.workspace.model.User;
import com.workspace.repository.ProductRepo;
import com.workspace.repository.UserRepo;

@Controller
public class MainController {

	@Autowired
	ProductRepo prepo;
	
	
	@Autowired
	UserRepo urepo;
	
	@RequestMapping("/")
	public String forAllReq()
	{
		return "login";
	}
	
	@RequestMapping("/products")
	public String hrefCall() {
		return "products";
	}
	@RequestMapping("/pwdChange")
	public String hrefCall1() {
		return "pwdChange";
	}
	@RequestMapping("/purchaseReport")
	public String hrefCall3() {
		return "purchaseReport";
	}
	@RequestMapping("/registerUser")
	public String hrefCall4() {
		return "register";
	}
	
	
	
	@GetMapping("/getLogin")
	public String getLogins(@RequestParam String role,@RequestParam String username,@RequestParam String pwd, Model m,HttpSession session) 
	{
	
		if(role.equalsIgnoreCase(role)&& username.equalsIgnoreCase(username)&& pwd.equalsIgnoreCase(pwd))
		{
			System.out.println("role :"+role);
			System.out.println("username :"+username);
			System.out.println("pwd :"+pwd);
			User user  = urepo.findByUsernameAndPasswordAndRole(username,pwd,role);
			if(user !=null) {
				System.out.println("user successfully autheticated");
				session.setAttribute("username", username);
			}else {
				System.out.println("user authetication failed");
				return "error";
			}
			if(role.equalsIgnoreCase("user")) {
				List<Product> prod1 = prepo.findAll();
				System.out.println("control is coming");
				m.addAttribute("products", prod1);
				return "user";
			} else {
				List<Product> prod1 = prepo.findAll();
				m.addAttribute("products", prod1);
				return "home";
			}
		}
		return "error";
//		else if(role.equalsIgnoreCase("user")&& username.equalsIgnoreCase("mahendra")&& pwd.equalsIgnoreCase("simplilearn"))
//		{
//			List<Product> prod1 = prepo.findAll();
//			m.addAttribute("products", prod1);
//			return "user";
//		}
//		else 
//		{
//			return "error";
//		}
	}
	
	@PostMapping("changePwd")
	public String changePassword(@RequestParam String currentPwd,@RequestParam String newPwd,@RequestParam String confirm,@RequestParam  String username)
	{
		System.out.println("username:"+username);
		System.out.println("currentPwd:"+currentPwd);
		System.out.println("newPwd:"+newPwd );
		System.out.println("confirm:"+confirm);
		User user = urepo.findByUsernameAndPassword(username,currentPwd);
		if(user != null) {
			System.out.println("user have correct passwrod updating new password....");
			int i =urepo.updateUserPwd(username,newPwd);
			System.out.println("no of row got modified : "+i);
			if(i!= 0) {
				System.out.println("password updated for user :"+username);
			}
		}else {
			
		}
		if(newPwd.equalsIgnoreCase(confirm)) 
		{
			return "success";
		}
		else {
			return "pwdChange";
		}
		
	}
	
	@GetMapping("/purchase")
	public String purchaseReport(@RequestParam String date,Model m) throws ParseException {
		System.out.println("calling");
		System.out.println("date :"+date);
//		2021-08-25
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date2 = dateFormat.parse(date);
		System.out.println(date2);
		List<Product> prod=prepo.findByDateGroupBy(dateFormat.format(date2));
		System.out.println(prod.size());
	m.addAttribute("products", prod);
		return "purchaserepo2";
	}
	
	@RequestMapping("/user")
	public String addEcom(@ModelAttribute("resultUser") User u,Model m) 
	{
	  List<User> listUsers = urepo.findByRole("user");
	System.out.println(listUsers);
	m.addAttribute("adminUsers", listUsers);
		
		return "resultUser";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@RequestParam String username,@RequestParam String password,
			@RequestParam String role) {
		System.out.println("Username:"+username);
		System.out.println("password:"+password);
		System.out.println("role:"+role);
		User user = new User(role,username,password);
		urepo.save(user);
		return "login";
	}
	
	
}
