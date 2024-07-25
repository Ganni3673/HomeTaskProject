package com.org.SpringDemo.json;

import java.util.Optional;

import com.org.SpringDemo.model.VendorModel;

public class VendorJson {
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpi() {
		return upi;
	}
	public void setUpi(String upi) {
		this.upi = upi;
	}
	private int id;
	    private String name;
	    private String email;
	    private String upi;
		public static Optional<VendorModel> stream() {
			// TODO Auto-generated method stub
			return null;
		}

}
