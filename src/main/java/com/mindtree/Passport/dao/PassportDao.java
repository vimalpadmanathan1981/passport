package com.mindtree.Passport.dao;

import java.util.List;

import com.mindtree.Passport.entity.Passport;
import com.mindtree.Passport.entity.Person;
import com.mindtree.Passport.exception.daoexception.ConnectivityException;
import com.mindtree.Passport.exception.daoexception.PersonidNot;

public interface PassportDao {

	Person getPersonDetails();

	boolean addToPersonDB(Person person);

	Passport getPassportDetails() throws PersonidNot ;

	boolean addToPassportDB(Passport passport);

	Person getInfoDetails() throws PersonidNot;

	List<Person> getAllInfoDetails();

}
