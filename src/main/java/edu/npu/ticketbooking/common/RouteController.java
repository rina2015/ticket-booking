package edu.npu.ticketbooking.common;

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

import edu.npu.ticketbooking.dao.RouteDAO;
import edu.npu.ticketbooking.model.Route;
/**
 * Handles requests for the application home page.
 */
@Controller
public class RouteController {
	
	private static final Logger logger = LoggerFactory.getLogger(RouteController.class);
	
	@RequestMapping(value = "/searchRoute", method = RequestMethod.GET)
	public String searchRoute(Locale locale, Model model,@RequestParam(value="routeId", defaultValue="") String routeId) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		//Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//String formattedDate = dateFormat.format(date);
		
		model.addAttribute("routeId", routeId );
		if (routeId.trim().equals("")){
		    return "";
		}
		else{
		    ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	ArrayList<Integer> A = new ArrayList<Integer>();
        RouteDAO routeDAO = (RouteDAO) context.getBean("routeDAO");
		    Route route = routeDAO.findByRouteId(Integer.parseInt(routeId));
		    model.addAttribute("route", route );
		    System.out.println("route : " + route);
		    return routeId;
		}
	}
	
	
	@RequestMapping(value = "/addRoute", method = RequestMethod.POST)
	public String addRoute(Locale locale, Model model,
	                          @RequestParam(value="from", defaultValue="") String from,
	                          @RequestParam(value="to", defaultValue="") String to,
	                          @RequestParam(value="price", defaultValue="") String price,
	                          @RequestParam(value="routeId", defaultValue="") String routeId) {
	    ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	ArrayList<Integer> A = new ArrayList<Integer>();
        RouteDAO routeDAO = (RouteDAO) context.getBean("routeDAO");
        //Create
        Route route = new Route(from, to, Float.parseFloat(price), Integer.parseInt(routeId));
	        routeDAO.insert(route);
	    model.addAttribute("route", route);
	    return routeId;	
	}
	
}
