package edu.npu.ticketbooking.model;

public class Customer
{
	int custId;
	String firstName;
	String lastName;
	int age;
	String gender;
	
	
	public Customer(int custId, String firstName, String lastName, int age, String gender) {
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
	
	public int getCustId() {
		return custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer [age=" + age + ", custId=" + custId + ", name=" + firstName
				+ "]";
	}
	
	
}
