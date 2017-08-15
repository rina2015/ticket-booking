package edu.npu.ticketbooking.dao;

import edu.npu.ticketbooking.model.Customer;

public interface CustomerDAO 
{
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public void updateCustomerName(int custId, String firstName, String lastName);
	public void deleteCustomer(int custId);
}