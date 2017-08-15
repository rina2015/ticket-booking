package edu.npu.ticketbooking.model;

public class Route
{
	String from;
	String to;
	Float price;
	int routeId;
	
	public Route(String from, String to, Float price, int routeId) {
		this.from = from;
		this.to = to;
		this.price = price;
		this.routeId = routeId;
	}
	
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public Float getPrice() {
		return price;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	public void setRouteId(int routeId){
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "Route [from=" + from + ", to=" + to + ", price=" + price + ", routeId=" + routeId + "]";
	}
}