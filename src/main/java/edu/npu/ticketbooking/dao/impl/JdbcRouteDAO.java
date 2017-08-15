package edu.npu.ticketbooking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import edu.npu.ticketbooking.dao.RouteDAO;
import edu.npu.ticketbooking.model.Route;

public class JdbcRouteDAO implements RouteDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Route route){
		
		String sql = "INSERT INTO ROUTE VALUES (?, ?, ?, ?);";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, route.getFrom());
			ps.setString(2, route.getTo());
			ps.setFloat(3, route.getPrice());
			ps.setInt(4, route.getRouteId());
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

	
	public Route findByRouteId(int routeId){
		
		String sql = "SELECT * FROM ROUTE WHERE ROUTE_ID = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, routeId);
			Route route = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				route = new Route(
					rs.getString("FROM"),
					rs.getString("TO"),
					rs.getFloat("PRICE"),
					rs.getInt("ROUTE_ID")
				);
			}
			rs.close();
			ps.close();
			return route;
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