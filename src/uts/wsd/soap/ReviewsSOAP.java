package uts.wsd.soap;

import uts.wsd.facade.*;
import java.io.IOException;
import java.util.Date;

import uts.wsd.domain.*;
import uts.wsd.DAO.*;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;


@WebService
public class ReviewsSOAP {

	@Resource
	private WebServiceContext context;
	
	private Author loggedAuthor = null;

	private Service getService() throws JAXBException, IOException {
		ServletContext application = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);

		// The web server can handle requests from different clients in parallel.
				// These are called "threads".
				//
				// We do NOT want other threads to manipulate the application object at the same
				// time that we are manipulating it, otherwise bad things could happen.
				//
				// The "synchronized" keyword is used to lock the application object while
				// we're manpulating it.
				synchronized (application) {
					Service service = (Service)application.getAttribute("service");
					if (service == null){
						service = new Service();
						service.setReviewsFilePath(application.getRealPath("WEB-INF/db/reviews.xml"));
						service.setAuthorsFilePath(application.getRealPath("WEB-INF/db/authors.xml"));
						application.setAttribute("service", service);
					}
					return service;
				}
	}


	@WebMethod
	public Reviews fetchReviews(){
		try {
			return getService().getReviewsObject();
		} catch (JAXBException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	@WebMethod
	public void login(String username, String password) throws JAXBException, IOException{
		for (Author author : getService().getAuthors()){
			if (author.getName().equals(username) && author.getPassword().equals(password)){
				loggedAuthor = author;
			}
		}
		
		if (loggedAuthor == null){
			System.out.println("Log in Failed");
		}
	}
	
	@WebMethod
	public void logout() throws JAXBException, IOException{
		if (loggedAuthor == null){
			System.out.println("You are not even logged-in!");
		}
		else {
			loggedAuthor = null;
			System.out.println("Logged out!");
		}
	}
	
	@WebMethod
	public void postReview(String headline, String description, int rating, int hotelId) throws Exception{
		if (loggedAuthor != null){
			Review review = new Review(0, hotelId, loggedAuthor.getId(), rating, new Date(), headline, description);
			if (getService().addReview(review)){
				System.out.println("Post review successfully!");
			}
		}
		else {
			throw new Exception("Please Log in first!");
		}
	}
	
	@WebMethod
	public void deleteReview(int reviewId) throws JAXBException, IOException{
		if (loggedAuthor != null){
			Review review = getService().getReviewById(reviewId);
			if (review != null){
				if (review.getAuthorId() == loggedAuthor.getId()){
					if (getService().deleteReview(review)){
						System.out.println("Delete review successfully!");
					}
				}
				else {
					System.out.println("You don't have the permission to delete this review.");
				}
			}
			else {
				System.out.println("This review doesn't exist.");
			}
		}
	}
}
