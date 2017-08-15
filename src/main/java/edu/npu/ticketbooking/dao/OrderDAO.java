package edu.npu.ticketbooking.dao;

import edu.npu.ticketbooking.model.Order;

public interface OrderDAO 
{
	public void insert(Order order);
	public Order findByCustomerId(int custId);
	public Order findByRouteId(int route_id);
}