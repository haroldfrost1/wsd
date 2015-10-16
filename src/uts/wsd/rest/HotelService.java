package uts.wsd.rest;

import javax.servlet.ServletContext;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import uts.wsd.facade.*;
import uts.wsd.domain.*;
import uts.wsd.DAO.*;

@Path("/hotel")
public class HotelService {

	@Context
	private ServletContext application;

	private Service getService(){
		// The web server can handle requests from different clients in parallel.
		// These are called "threads".
		//
		// We do NOT want other threads to manipulate the application object at the same
		// time that we are manipulating it, otherwise bad things could happen.
		//
		// The "synchronized" keyword is used to lock the application object while
		// we're manpulating it.
		synchronized (application) {

			/*
			 * Deprecated codes before facade pattern implemented			
			 */
			//			   HotelsDAO hotelsApp = (HotelsDAO)application.getAttribute("hotelsApp");
			//			   if (hotelsApp == null) {
			//			    hotelsApp = new HotelsDAO();
			//			    hotelsApp.setFilePath(application.getRealPath("WEB-INF/db/hotels.xml"));
			//			    application.setAttribute("hotelsApp", hotelsApp);
			//			   }
			//			   return hotelsApp;
			//			  }
			Service service = (Service)application.getAttribute("service");
			if (service == null){
				service = new Service();
				service.setHotelsFilePath(application.getRealPath("WEB-INF/db/hotels.xml"));
				application.setAttribute("service", service);
			}
			return service;
		}

	}

	@Path("info")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Hotel getHotelById(@QueryParam("hotelId") int hotelId){
		return getService().getHotelById(hotelId);
	}
	
	
	@Path("search")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Hotels searchHotels(@QueryParam("name") String name, @QueryParam("country") String country,
			@QueryParam("city") String city) {

		Hotels resultHotels = new Hotels();

		for (Hotel h : getService().getHotels()) {

			if (name != null) {
				if (!h.getName().toLowerCase().contains(name.toLowerCase())) {
					continue;
				}
			}

			if (country != null) {
				if (!h.getCountry().equalsIgnoreCase(country)) {
					continue;
				}
			}

			if (city != null) {
				if (!h.getCity().equalsIgnoreCase(city)) {
					continue;
				}
			}

			resultHotels.addHotel(h);
		}

		return resultHotels;
	}
}
