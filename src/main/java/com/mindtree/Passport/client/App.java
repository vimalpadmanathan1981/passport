package com.mindtree.Passport.client;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mindtree.Passport.entity.Passport;
import com.mindtree.Passport.entity.Person;
import com.mindtree.Passport.exception.serviceexception.ConnectivityService;
import com.mindtree.Passport.exception.serviceexception.PersonidNotservice;
import com.mindtree.Passport.service.PassportService;
import com.mindtree.Passport.service.impl.PassportServiceimpl;


/**
 * Hello world!
 *
 */
public class App 
{
	private static Scanner scanner = new Scanner(System.in);
	private static PassportService passportService = new PassportServiceimpl(); 
    public static void main( String[] args )
    {
    		boolean flag =false;
    		int choice;
    		do {
    			System.out.println(
    					"1 --> Create person data\n 2 --> Create passport Details\n 3--> get user info for given id\n 4-->sort the city\n Enter your choice");
    			choice = scanner.nextInt();
    			switch (choice) {
    			case 1:
    				System.out.println("---------------  Create hotel data----------");
    				Person person = passportService.getPersonDetails();
    				flag = passportService.addToPersonDB(person);
    				if(flag) {
    					System.out.println("insertd successfully");
    				}else {
    					System.out.println("not insertd successfully");
    				}
    				break;
    			case 2:
    				try {
						Passport passport = passportService.getPassportDetails();
						flag = passportService.addToPassportDB(passport);
						if(flag) {
	    					System.out.println("insertd successfully");
	    				}else {
	    					System.out.println("not insertd successfully");
	    				}
					} catch (PersonidNotservice e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
    				break;
    			case 3:
    				try {
						Person persons = passportService.getInfoDetails();
						System.out.println(persons);
					} catch (PersonidNotservice e) {
						System.out.println(e.getMessage());
					}
    				break;
    			case 4:
    				List<Person> persons = passportService.getAllInfoDetails();
    				Iterator<Person> ci = persons.iterator();
    				while (ci.hasNext()) {
						Person person2 = (Person) ci.next();
						System.out.println(person2);
					}
    				break;
    			default:
    				System.out.println("-----------------Existing Main Menu-------------------");
    			}
    		} while (choice <= 4 && choice >= 1);
    }
}
