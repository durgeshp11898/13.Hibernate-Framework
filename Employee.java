package com.jbk.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Employee
{
	@Id
	private int eid;
	private String name;
	private double esalary;
	private  int getEid() {
		return eid;
	}
	private void setEid(int eid) {
		this.eid = eid;
	}
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	private double getEsalary() {
		return esalary;
	}
	private void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	public  Employee() 
	{
	
	}
	
	public Employee(int eid, String name, double esalary) {
		super();
		this.eid = eid;
		this.name = name;
		this.esalary = esalary;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", esalary=" + esalary + "]";
	}
	
}
