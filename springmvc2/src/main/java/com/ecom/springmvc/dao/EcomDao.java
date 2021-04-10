package com.ecom.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecom.springmvc.model.Ecom;
@Component // use this if we want spring to create object of this EcomDao class
public class EcomDao 
{
	@Autowired //using this we get sessionFactory object object mention in ecom-servlet.xml in bean tag
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Ecom> getEcoms()
	{
	 Session session=sessionFactory.getCurrentSession();
     List<Ecom> Ecoms=session.createQuery("from Ecom",Ecom.class).list();
	 
     return Ecoms;
	}
    
	@Transactional
	public void addEcom(Ecom a) {
		 Session session=sessionFactory.getCurrentSession();
		 session.save(a);
		
	}
	@Transactional
	public void updateEcom(Ecom a) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("adding edited data in table");
		session.update(a);
		System.out.println("successfully updated the data");
		
	}
   
	@Transactional //for begining transaction and commit transcation
	public Ecom getEcom(int aid) {
		 Session session=sessionFactory.getCurrentSession();
		Ecom a=session.get(Ecom.class, aid);
		 return a;
	}
}
