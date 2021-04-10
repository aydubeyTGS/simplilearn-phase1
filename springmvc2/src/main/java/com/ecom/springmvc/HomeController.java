package com.ecom.springmvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.springmvc.dao.EcomDao;
import com.ecom.springmvc.model.Ecom;

@Controller
public class HomeController
{
	@Autowired
	EcomDao dao;
	
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name", "Ecoms");
	}
	
	@RequestMapping("/")
   public String home()
   {
	   return "index";
   }
	
	@GetMapping("getEcoms")
	public String getEcoms(Model m) 
	{
		m.addAttribute("result",dao.getEcoms());
		return "showEcoms";
	}

	@GetMapping("getUser")
	public String getEcoms(@RequestParam int aid,Model m) 
	{
		Ecom ecom = dao.getEcom(aid);
		if(ecom !=null) {
			m.addAttribute("result",ecom);
			return "showEcoms";
		}else {
			return "error";
		}
	}
	@PostMapping("updateUser")
	public String updateEcoms(@RequestParam int aid,@RequestParam String pname,@RequestParam int quantity,@RequestParam double price,Model m) 
	{
		System.out.println("getting data from edit form");
		Ecom ecom = new Ecom(aid, pname, quantity, price);
		m.addAttribute("ecom",ecom);
		dao.updateEcom(ecom);
		System.out.println("calling EcomDao");
		return "result";
		
	}
	
	
//	@RequestMapping("searchUser")
//	public String addEcom(@ModelAttribute("result") Ecom a) 
//	{
//	  dao.addEcom(a);
//		return "result";
//	}
	
}









