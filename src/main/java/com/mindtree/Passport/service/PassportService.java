package com.mindtree.Passport.service;

import java.util.List;

import com.mindtree.Passport.entity.Passport;
import com.mindtree.Passport.entity.Person;
import com.mindtree.Passport.exception.daoexception.PersonidNot;
import com.mindtree.Passport.exception.serviceexception.ConnectivityService;
import com.mindtree.Passport.exception.serviceexception.PersonidNotservice;

public interface PassportService {

	Person getPersonDetails();

	boolean addToPersonDB(Person person);

	Passport getPassportDetails() throws PersonidNotservice;

	boolean addToPassportDB(Passport passport);

	Person getInfoDetails() throws PersonidNotservice;

	List<Person> getAllInfoDetails();

}
