package com.mpp.group.proj.model;
import java.sql.Date;
import java.time.LocalDate;

public class Animal {
	
	private int id;
	private String name;
	private boolean neutered;
	private Date birth;
	private String color;
	private Date deceased;
	private boolean status;
	private String specie;
	private String breed;
	private Gender gender;
	
	private String date1;
	private String date2;
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isNeutered() {
		return neutered;
	}
	public void setNeutered(boolean neutered) {
		this.neutered = neutered;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getDeceased() {
		return deceased;
	}
	public void setDeceased(Date deceased) {
		this.deceased = deceased;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public Animal(){}
	
	public Animal(int id){this.id = id;}
	
	public Animal(int id, String name, boolean neutered, Date birth, String color, Date deceased,
			boolean status, String specie, String breed) {
		super();
		this.id = id;
		this.name = name;
		this.neutered = neutered;
		this.birth = birth;
		this.color = color;
		this.deceased = deceased;
		this.status = status;
		this.specie = specie;
		this.breed = breed;
	}
	
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	
	public String toString()
	{
		String str = "[";
		str += " id = " + this.id;
		str += ", name = " + this.name;
		str += ", neutered = " + this.neutered;
		str += ", birth = " + this.birth;
		str += ", color = " + this.color;
		str += ", deceased = " + this.deceased;
		str += ", status = " + this.status;
		str += ", gender = " + this.gender;
		str += ", date1 = " + this.date1;
		str += ", date2 = " + this.date2;
		str += ", breed = " + this.breed + "]";
		return str;
	}
	
	
	
}
