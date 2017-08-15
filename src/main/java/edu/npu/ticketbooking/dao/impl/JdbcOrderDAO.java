package edu.npu.ticketbooking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import edu.npu.ticketbooking.dao.OrderDAO;
import edu.npu.ticketbooking.model.Order;

public class JdbcOrderDAO implements OrderDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Order order){
		
		String sql = "INSERT INTO ORDERNEW VALUES (?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getCustId());
			ps.setInt(2, order.getRouteId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
public Order findByRouteId(int routeId){
		
		String sql = "SELECT * FROM ORDERNEW WHERE ROUTE = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, routeId);
			Order order = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				order = new Order(
					rs.getInt("customer"),
					rs.getInt("route")
				);
			}
			rs.close();
			ps.close();
			return order;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
public Order findByCustomerId(int custId){
	
	String sql = "SELECT * FROM ORDERNEW WHERE CUSTOMER = ?";
	
	Connection conn = null;
	
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, custId);
		Order order = null;
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			order = new Order(
				rs.getInt("customer"),
				rs.getInt("route")
			);
		}
		rs.close();
		ps.close();
		return order;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	} finally {
		if (conn != null) {
			try {
			conn.close();
			} catch (SQLException e) {}
		}
	}
}
}