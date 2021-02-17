 package com.mindtree.Passport.service.impl;

import java.util.List;

import com.mindtree.Passport.dao.PassportDao;
import com.mindtree.Passport.dao.impl.PassportDaoImpl;
import com.mindtree.Passport.entity.Passport;
import com.mindtree.Passport.entity.Person;
import com.mindtree.Passport.exception.daoexception.ConnectivityException;
import com.mindtree.Passport.exception.daoexception.PersonidNot;
import com.mindtree.Passport.exception.serviceexception.*;
import com.mindtree.Passport.service.PassportService;

public class PassportServiceimpl implements PassportService {
	private PassportDao dao = new PassportDaoImpl(); 
	@Override
	public Person getPersonDetails() {
		// TODO Auto-generated method stub
		return dao.getPersonDetails();
	}
	@Override
	public boolean addToPersonDB(Person person) {
		// TODO Auto-generated method stub
		return dao.addToPersonDB(person);
	}
	@Override
	public Passport getPassportDetails() throws PersonidNotservice {
		// TODO Auto-generated method stub
		try {
			return dao.getPassportDetails();
		} catch (PersonidNot e) {
			// TODO Auto-generated catch block
			throw new PersonidNotservice("id not found");
		}
	}
	@Override
	public boolean addToPassportDB(Passport passport) {
		// TODO Auto-generated method stub
		return dao.addToPassportDB(passport);
	}
	@Override
	public Person getInfoDetails() throws PersonidNotservice {
		// TODO Auto-generated method stub
		try {
			return dao.getInfoDetails();
		} catch (PersonidNot e) {
			// TODO Auto-generated catch block
			throw new PersonidNotservice("id not found");
		} 
	}
	@Override
	public List<Person> getAllInfoDetails() {
		// TODO Auto-generated method stub
		 return dao.getAllInfoDetails();
	}

}
