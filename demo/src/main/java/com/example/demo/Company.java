package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Company {
	private int cid;
	private String cname;
	
	public Company() {
		System.out.println("Inside company class");
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "Company[cid : "+this.cid +" company name : "+ this.cname+ "]";
	}
	public void display()
	{
		System.out.println("Inside Company display");
	}
	
}
