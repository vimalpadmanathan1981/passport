package com.mindtree.Passport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.Passport.dao.PassportDao;
import com.mindtree.Passport.entity.Passport;
import com.mindtree.Passport.entity.Person;
import com.mindtree.Passport.exception.daoexception.PersonidNot;
import com.mindtree.Passport.util.DataBase;

public class PassportDaoImpl implements PassportDao {
	private static Scanner scanner = new Scanner(System.in);
	
	@Override
	public Person getPersonDetails() {
		// TODO Auto-generated method stub
		System.out.println("enter the person id");
		short id = scanner.nextShort();
		System.out.println("enter the person name");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("enter the person birth place");
		String place = scanner.nextLine();
		System.out.println("enter the person age");
		short age = scanner.nextShort();
		return new Person(id, name, place, age);
	}

	@Override
	public boolean addToPersonDB(Person person) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		try {
			Connection con = DataBase.getConnection();
			String sql2 = "insert into person values(?,?,?,?)";
			preparedStatement = con.prepareStatement(sql2);
			preparedStatement.setShort(1, person.getId());
			preparedStatement.setString(2, person.getName());
			preparedStatement.setString(3, person.getPlace());
			preparedStatement.setShort(4, person.getAge());
			int j = preparedStatement.executeUpdate();
			if (j > 0) {
				return true;
			} else
				return false;
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Passport getPassportDetails() throws PersonidNot {
		// TODO Auto-generated method stub
		System.out.println("enter the person id");
		short id = scanner.nextShort();
		boolean p;
		p = getIdOfPerson(id);
		if (p) {
			System.out.println("enter the passport id");
			short passid = scanner.nextShort();
			System.out.println("enter the passport number");
			scanner.nextLine();
			String passnumber = scanner.nextLine();
			return new Passport(passid, passnumber, id);
		} else {
			throw new PersonidNot("id not found");
		}
	}

	private boolean getIdOfPerson(short id) throws PersonidNot {
		// TODO Auto-generated method stub
		try {
			Connection con = DataBase.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from person where id = " + id + "");
			if (rs.next() == false) {
				throw new PersonidNot("id not found");
			} else {
				System.out.println(rs.getInt(1));
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonidNot("id not found");
		}

	}

	@Override
	public boolean addToPassportDB(Passport passport) {
		// TODO Auto-generated method stub
		try {
			Connection con = DataBase.getConnection();
			String sql2 = "insert into Passport values(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql2);
			preparedStatement.setShort(1, passport.getPassportid());
			preparedStatement.setString(2, passport.getPassportnumber());
			preparedStatement.setShort(3, passport.getId());
			int j = preparedStatement.executeUpdate();
			if (j > 0) {
				return true;
			} else
				return false;
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Person getInfoDetails() throws PersonidNot {
		// TODO Auto-generated method stub
		System.out.println("enter the person id");
		short id = scanner.nextShort();
		try {
			Connection con = DataBase.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select * from person inner join passport  on person.id=passport.id where person.id = " + id + "");
			rs.next();
			return new Person(rs.getShort("id"), rs.getString("name"), rs.getString("place"), rs.getShort("age"),new Passport(rs.getShort("passid"), rs.getString("passnum")));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonidNot("id not found");
		}

	}

	@Override
	public List<Person> getAllInfoDetails() {
		// TODO Auto-generated method stub
		List<Person> ls = new ArrayList<Person>();
		try {
			Connection con = DataBase.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select * from person inner join passport  on person.id=passport.id order by person.place");
			while (rs.next()) {
				ls.add(new Person(rs.getShort("id"), rs.getString("name"), rs.getString("place"), rs.getShort("age"),
						new Passport(rs.getShort("passid"), rs.getString("passnum"))));
			}
			return ls;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
