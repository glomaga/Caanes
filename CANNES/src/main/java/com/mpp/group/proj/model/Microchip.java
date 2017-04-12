package com.mpp.group.proj.model;


import java.util.Date;

public class Microchip {
	
	private int id;
	private String description;
	private String brand;
	private Date implantDate;
	private int implantSite;
	
	
	
	public Microchip() {
		super();
	}
	
	public Microchip(int id){
		this.id=id;
	}


	public Microchip(int id , String description, String brand, Date implantDate, int implantSite) {
		super();
		this.id= id;
		this.description = description;
		this.brand = brand;
		this.implantDate = implantDate;
		this.implantSite = implantSite;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getImplantDate() {
	//	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	//	dateFormat.format(implantDate);
		return implantDate;
	}
	public void setImplantDate(Date implantDate) {
		// LocalDate today = LocalDate.now();
		//this.implantDate = today;
		this.implantDate = implantDate;
	}
	public int getImplantSite() {
		return implantSite;
	}
	public void setImplantSite(int implantSite) {
		this.implantSite = implantSite;
	}

	@Override
	public String toString() {
		return "Microchip [id=" + id + ", description=" + description + ", brand=" + brand + ", implantDate="
				+ implantDate + ", implantSite=" + implantSite + "]";
	}
	
	
}
