package edu.npu.ticketbooking.dao;

import edu.npu.ticketbooking.model.Route;

public interface RouteDAO 
{
	public void insert(Route route);
	public Route findByRouteId(int routetId);
}