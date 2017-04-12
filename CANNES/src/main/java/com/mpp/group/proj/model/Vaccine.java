package com.mpp.group.proj.model;

import java.util.Date;

public class Vaccine {

private int id;
private int animal;
private Date date;
private String name;
private String batch;
private int doctor;


public Vaccine() {
	super();
}
public Vaccine(int id) {
	super();
	this.id=id;
}


public Vaccine(int id, int animal,Date date, String name, String batch,int doctor) {
	super();
	this.id=id;
	this.animal=animal;
	this.date = date;
	this.name = name;
	this.batch = batch;
	this.doctor= doctor;
}


public Date getDate() {
	return date;
}



public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public void setDate(Date date) {
	this.date = date;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getBatch() {
	return batch;
}


public void setBatch(String batch) {
	this.batch = batch;
}


public int getAnimal() {
	return animal;
}


public void setAnimal(int animal) {
	this.animal = animal;
}
public int getDoctor() {
	return doctor;
}
public void setDoctor(int doctor) {
	this.doctor = doctor;
}
@Override
public String toString() {
	return "Vaccine [id=" + id + ", animal=" + animal + ", date=" + date + ", name=" + name + ", batch=" + batch
			+ ", doctor=" + doctor + "]";
}







}
