package com.mpp.group.proj.model;
import java.time.LocalDate;

public class Animal {
	
	private int id;
	private String name;
	private boolean neutered;
	private LocalDate birth;
	private String color;
	private LocalDate deceased;
	private boolean status;
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
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public LocalDate getDeceased() {
		return deceased;
	}
	public void setDeceased(LocalDate deceased) {
		this.deceased = deceased;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Animal(int id, String name, boolean neutered, LocalDate birth, String color, LocalDate deceased,
			boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.neutered = neutered;
		this.birth = birth;
		this.color = color;
		this.deceased = deceased;
		this.status = status;
	}
	
	
}
