package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Feedback {
	@Id
//	@GeneratedValue
	private int id;
	private String uname;
	private String feedback;
	
	public Feedback() {
		
	}
	public Feedback(String uname, String feedback) {
		this.uname = uname;
		this.feedback = feedback;
	}
	
	public int getId() {
		return id;
	}
	
	

	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return String.format("Feedback [id=%s, uname=%s, feedback=%s]", id, uname, feedback);
	}


	

}
