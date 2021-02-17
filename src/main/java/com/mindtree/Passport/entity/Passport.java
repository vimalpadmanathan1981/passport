package com.mindtree.Passport.entity;

public class Passport {
	private short passportid;
	private String passportnumber;
	private short id ;
	
	public Passport() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return String.format("Passport [passportid=%s, passportnumber=%s]", passportid, passportnumber);
	}


	public short getId() {
		return id;
	}


	public void setId(short id) {
		this.id = id;
	}


	public Passport(short passportid, String passportnumber, short id) {
		super();
		this.passportid = passportid;
		this.passportnumber = passportnumber;
		this.id = id;
	}


	public Passport(short passportid, String passportnumber) {
		super();
		this.passportid = passportid;
		this.passportnumber = passportnumber;
	}


	public short getPassportid() {
		return passportid;
	}


	public String getPassportnumber() {
		return passportnumber;
	}


	public void setPassportid(short passportid) {
		this.passportid = passportid;
	}


	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}
	
	
}
