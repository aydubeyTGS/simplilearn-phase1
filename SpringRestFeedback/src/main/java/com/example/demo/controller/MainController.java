package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Feedback;
import com.example.demo.repository.FeedbackRepo;


@RestController
public class MainController {
	

	@Autowired
	FeedbackRepo repo;

	@RequestMapping("/")

   public String home()
   {
	   return "home";
   }
	@RequestMapping("/getAllFeedback")
	
	public List<Feedback> home1()
	{
	
		 List<Feedback> feed=repo.findAll();
		  return feed;
	}
	

	
	 @PostMapping(value="feedback")
	  public Feedback addFeedback(@RequestBody Feedback feedback)
	  {
		  repo.save(feedback);
		  return feedback;
	  }
}
