package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//The below annotation can be used to create the bean inside the spring container
@Component
public class Employee {
	private int aid;
	private String ename;
	
	@Autowired
	//qualifier searches by the component name
	@Qualifier("lap")
	private Laptop laptop;

	public Employee() {
		System.out.println("object created");
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public Laptop getLaptop() {
		return laptop;
	}
	
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public void display()
	{
		System.out.println("Employee display");
	}
	
	public void show()
	{
		System.out.println("Employee[id : "+this.aid +" name : "+ this.ename+ "] uses "+laptop.toString());
	}
	
}
