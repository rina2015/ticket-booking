package edu.npu.ticketbooking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import edu.npu.ticketbooking.dao.CustomerDAO;
import edu.npu.ticketbooking.model.Customer;

public class JdbcCustomerDAO implements CustomerDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Customer customer){
		
		String sql = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setInt(3, customer.getAge());
			ps.setString(4, customer.getGender());
			ps.setInt(5, customer.getCustId());
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
	
	public void updateCustomerName(int custId, String firstName, String lastName){
//String sql = "update customer set `first name`=" + firstName + ",`last name`=" + lastName + " where cust_id="+ custId;
		String sql = "update customer set `first name`=?,`last name`=? where cust_id=?";	
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setInt(3, custId);
			Customer customer = null;
		    ps.executeUpdate();
			/*if (rs.next()) {
				customer = new Customer(
					rs.getInt("CUST_ID"),
					rs.getString("FIRST NAME"),
					rs.getString("LAST NAME"),
					rs.getInt("Age"),
					rs.getString("GENDER")
				);
			}
			rs.close();*/
			ps.close();
			//return customer;
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
	public void deleteCustomer(int custId){
		//JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "DELETE FROM CUSTOMER WHERE CUST_ID = ?";
		//jdbcTemplate.update(sql);
		Connection conn = null;
		
		try {
			//JdbcTemplate jdbcTemplate = new JdbcTemplate();
			conn = dataSource.getConnection();
			//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			//jdbcTemplate.update(sql);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ps.executeUpdate();
			/*if (rs.next()) {
				customer = new Customer(
					rs.getInt("CUST_ID"),
					rs.getString("FIRST NAME"),
					rs.getString("LAST NAME"),
					rs.getInt("Age"),
					rs.getString("GENDER")
				);
			}
			rs.close();*/
			ps.close();
			//return customer;
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
	public Customer findByCustomerId(int custId){
		
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(
					rs.getInt("CUST_ID"),
					rs.getString("FIRST NAME"),
					rs.getString("LAST NAME"),
					rs.getInt("Age"),
					rs.getString("GENDER")
				);
			}
			rs.close();
			ps.close();
			return customer;
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