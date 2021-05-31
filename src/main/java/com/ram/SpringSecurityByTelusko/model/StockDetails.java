package com.ram.SpringSecurityByTelusko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stock_Details")
public class StockDetails 
{
	@Id
	@GeneratedValue(generator="id" ,strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Rate")
	private int rate;
	@Column(name="Status")
	private String status;
	@Column(name="Quantity")
	private int quantity;

	public StockDetails()
	{

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

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "StockDetails [id=" + id + ", name=" + name + ", rate=" + rate + ", status=" + status + ", quantity="
				+ quantity + "]";
	}
	
	
}
