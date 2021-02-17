package com.mindtree.Passport.entity;

public class Person {
	private short id ;
	private String name;
	private String place;
	private short age;
	private short passportid;
	private Passport passport;
	
	public Person(short id, String name, String place, short age, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.age = age;
		this.passport = passport;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(short id, String name, String place, short age) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.age = age;
	}

	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPlace() {
		return place;
	}

	public short getAge() {
		return age;
	}

	public short getPassportid() {
		return passportid;
	}

	public void setId(short id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public void setPassportid(short passportid) {
		this.passportid = passportid;
	}

	@Override
	public String toString() {
		return String.format("Person [id=%s, name=%s, place=%s, age=%s, passport=%s]", id, name, place, age, passport);
	}
	
}
