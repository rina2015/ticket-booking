package edu.npu.ticketbooking.services;

import java.util.ArrayList;



public interface CustomerService {
	public Float calculateTotalPrice(ArrayList<Integer> custIDs);
	public void updateCustomerName(int custId, String firstName, String lastName);
    public void deleteCustomer(int custId);
}