package com.hibernate.crreteria;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_info1")
public class Customer
{
	@Id
  private int id;
  private String name;
  private int mark;
  private int age;
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
public int getMark() {
	return mark;
}
public void setMark(int mark) {
	this.mark = mark;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Customer(int id, String name, int mark, int age) {
	super();
	this.id = id;
	this.name = name;
	this.mark = mark;
	this.age = age;
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "\nCustomer [id=" + id + ", name=" + name + ", mark=" + mark + ", age=" + age + "]";
}
  
  
}
