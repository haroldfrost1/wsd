package uts.wsd.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import uts.wsd.domain.*;
import uts.wsd.facade.Service;
import uts.wsd.DAO.*;

@Path("/review")
public class ReviewService {

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
			/****************
			 * Deprecated
			 */
//			ReviewsDAO reviewsApp = (ReviewsDAO)application.getAttribute("reviewsApp");
//			if (reviewsApp == null) {
//				reviewsApp = new ReviewsDAO();
//				reviewsApp.setFilePath(application.getRealPath("WEB-INF/db/reviews.xml"));
//				application.setAttribute("reviewsApp", reviewsApp);
//			}
//			return reviewsApp;
			/****************/
			
			Service service = (Service)application.getAttribute("service");
			if (service == null){
				service = new Service();
				service.setReviewsFilePath(application.getRealPath("WEB-INF/db/reviews.xml"));
				application.setAttribute("service", service);
			}
			return service;
		}
	}

	@Path("info")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Review getReviewById(@QueryParam("reviewId") int reviewId){
		return getService().getReviewById(reviewId);
	}
	
	@Path("search")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Reviews searchReviews(@QueryParam("hotelId") Integer hotelId, @QueryParam("startDate") String startDateStr,
			@QueryParam("endDate") String endDateStr, @QueryParam("starRating") Integer starRating) {

		Reviews resultReviews = new Reviews();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (hotelId == null) {
			throw new RuntimeException("No Hotel ID");
		}

		for (Review r : getService().getReviews()) {

			if (r.getHotelId() != hotelId.intValue()) {
				continue;
			}

			if (startDateStr != null) {
				Date startDate;
				try {
					startDate = df.parse(startDateStr);
					if (r.getDate().compareTo(startDate) < 0) {
						continue;
					}

				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			if (endDateStr != null) {
				Date endDate;
				try {
					endDate = df.parse(endDateStr);
					if (r.getDate().compareTo(endDate) > 0) {
						continue;
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			if (starRating != null) {
				if (r.getRating() != starRating.intValue()) {
					continue;
				}
			}

			resultReviews.addReview(r);
		}

		return resultReviews;
	}
}
