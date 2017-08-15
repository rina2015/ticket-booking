package edu.npu.ticketbooking.common;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.npu.ticketbooking.dao.CustomerDAO;
import edu.npu.ticketbooking.model.Customer;
import edu.npu.ticketbooking.services.CustomerServiceImpl;
/**
 * Handles requests for the application home page.
 */
@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/searchCustomer", method = RequestMethod.GET)
	public String searchCustomer(Locale locale, Model model,@RequestParam(value="custId", defaultValue="") String custId) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		//Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//String formattedDate = dateFormat.format(date);
		
		model.addAttribute("custId", custId );
		if (custId.trim().equals("")){
		    return "SearchCustomer";
		}
		else{
		    ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	ArrayList<Integer> A = new ArrayList<Integer>();
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		    Customer customer = customerDAO.findByCustomerId(Integer.parseInt(custId));
		    model.addAttribute("customer", customer );
		    System.out.println("customer : " + customer);
		    return "customerInfo";
		}
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String addCustomer(Locale locale, Model model) {
	    return "AddCustomer";	
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(Locale locale, Model model,
	                          @RequestParam(value="custId", defaultValue="") String custId,
	                          @RequestParam(value="firstName", defaultValue="") String firstName,
	                          @RequestParam(value="lastName", defaultValue="") String lastName,
	                          @RequestParam(value="age", defaultValue="") String age,
	                          @RequestParam(value="gender", defaultValue="") String gender) {
	    ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	ArrayList<Integer> A = new ArrayList<Integer>();
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        //Create
        Customer customer = new Customer(Integer.parseInt(custId), firstName, lastName, Integer.parseInt(age), gender);
	        customerDAO.insert(customer);
	    model.addAttribute("customer", customer);
	    return "AddedCustomer";	
	}
	
	
    @RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	public String updateCustomerName(Locale locale, Model model, @RequestParam(value="custId", defaultValue="") String custId,
	                                 @RequestParam(value="firstName", defaultValue="") String firstName,
	                          @RequestParam(value="lastName", defaultValue="") String lastName) {
	    ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	CustomerServiceImpl customerService = new CustomerServiceImpl();
    	customerService.updateCustomerName(Integer.parseInt(custId), firstName, lastName);
	    return custId;
	}
	
	
}
