package com.mpp.group.proj.model;

public class Email {

	private int id;
	private String email;
	private boolean primary;
		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPrimary() {
		return primary;
	}



	public void setPrimary(boolean primary) {
		this.primary = primary;
	}



	public Email(){}
		
	public Email(int id) {
		super();
		this.id = id;
	}

	public Email(int id, String email, boolean primary) {
		super();
		this.id = id;
		this.email = email;
		this.primary = primary;
	}
	
	public String toString()
	{
		String str = "[";
		str += " id = " + this.id;
		str += ", email = " + this.email;
		str += ", primary = " + this.primary + "]";
		return str;
	}
	
	
	
}
