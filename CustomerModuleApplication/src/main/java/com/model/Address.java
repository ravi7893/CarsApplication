package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="Customer_Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int aid;
	@NotNull
	@Column(name="Door_No")
	private String doorNo;
	@NotNull
	@Column(name="Street_Name")
	private String street;
	@NotNull
	@Column(name="Area_Name")
	private String area;
	@NotNull
	@Column(name="City")
	private String city;
	@NotNull
	@Column(name="state")
	private String state;
	@NotNull
	@Column(name="pincode")
	private int pincode;
	
    public Address() {
		
	}
	public Address(@NotNull String doorNo, @NotNull String street, @NotNull String area, @NotNull String city, @NotNull String state, @NotNull int pincode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode= pincode;
	}
	
	/*
	 * public int getAid() { return aid; }
	 */
	/*
	 * public void setAid(int aid) { this.aid = aid; }
	 */
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode +  "]";
	}
	
	
	

}
