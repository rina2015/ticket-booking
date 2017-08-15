package edu.npu.ticketbooking.services;
import edu.npu.ticketbooking.dao.CustomerDAO;
import edu.npu.ticketbooking.dao.OrderDAO;
import edu.npu.ticketbooking.dao.RouteDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService {
    public Float calculateTotalPrice(ArrayList<Integer> custIds) {
    	ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	Float totalPrice = new Float(0.0f);
    	OrderDAO orderDAO = (OrderDAO) context.getBean("orderDAO");
    	RouteDAO routeDAO = (RouteDAO) context.getBean("routeDAO");
    	for (Integer custId: custIds) {
    		
    		int routeId = orderDAO.findByCustomerId(custId).getRouteId();
    		
    		float price = routeDAO.findByRouteId(routeId).getPrice(); 
    		totalPrice+=price;
    	}
    	return totalPrice;
    }
    
    public void updateCustomerName(int custId, String firstName, String lastName){
    	ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
    	customerDAO.updateCustomerName(custId, firstName, lastName);
    	
    }
    
    public void deleteCustomer(int custId){
    	ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
    	customerDAO.deleteCustomer(custId);
    }
}