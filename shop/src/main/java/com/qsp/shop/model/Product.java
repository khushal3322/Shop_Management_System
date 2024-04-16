package com.qsp.shop.model;

import java.sql.Date;

public class Product {
	private int p_id;
	private String p_name;
	private int p_price;
	private int p_qauntity;
	private int p_availability;
	private Date date;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_qauntity() {
		return p_qauntity;
	}
	public void setP_qauntity(int p_qauntity) {
		this.p_qauntity = p_qauntity;
	}
	public int getP_availability() {
		return p_availability;
	}
	public void setP_availability(int p_availability) {
		this.p_availability = p_availability;
	}
	public void setP_availability(boolean i_p_availability) {
		// TODO Auto-generated method stub
		
	}
	

}
