package edu.npu.ticketbooking.model;

public class Order
{
	int custId;
    int routeId;
	
	
	public Order(int custId, int routeId) {
		this.custId = custId;
		this.routeId = routeId;
	}
	
	public int getCustId() {
		return custId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public void setRouteId(int routeId) {
		this.custId = routeId;
	}
	
	

	@Override
	public String toString() {
		return "Order [custId=" + custId + ", routeId=" + routeId + "]";
	}
	
	
}
