package com.demo.services.employee.model;

public class Address {
	
	String city;
	String streetAddress;
	@Override
	public String toString() {
		return "Address [city=" + city + ", streetAddress=" + streetAddress + "]";
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	

}
