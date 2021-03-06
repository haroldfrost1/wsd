package uts.wsd.facade;

import java.util.ArrayList;

import uts.wsd.DAO.*;
import uts.wsd.domain.*;
/*
 *  Using Facade design pattern
 *  
 *  This class provide an interface
 *  that abstracts all DAOs
 */
public class Service {
	
	private HotelsDAO hotelsDAO;
	private AuthorsDAO authorsDAO;
	private ReviewsDAO reviewsDAO;
	
	public Service(){
		this.hotelsDAO = new HotelsDAO_Impl();
		this.authorsDAO = new AuthorsDAO_Impl();
		this.reviewsDAO = new ReviewsDAO_Impl();
	}
	
//	/*******************
//	 * File Path setters
//	 ********************/
//	public void setHotelsFilePath(String filePath){
//		this.hotelsDAO.setFilePath(filePath);
//	}
//	
//	public void setReviewsFilePath(String filePath){
//		this.reviewsDAO.setFilePath(filePath);
//	}
//	
//	public void setAuthorsFilePath(String filePath){
//		this.authorsDAO.setFilePath(filePath);
//	}

	/*******************
	 * HotelsDAO methods
	 ********************/
	public Hotel getHotelById(int hotelId) {
		return hotelsDAO.getHotelById(hotelId);
	}

	public ArrayList<Hotel> getHotels() {
		return hotelsDAO.getHotels();
	}
	
	public Hotel getHotelByName(String hotelname) {
		return hotelsDAO.getHotelByName(hotelname);
	}

	public boolean addHotel(Hotel hotel) {
		return hotelsDAO.addHotel(hotel);
	}
	/*******************
	 * ReviewsDAO methods
	 ********************/
	public Review getReviewById(int reviewId) {
		return reviewsDAO.getReviewById(reviewId);
	}

	public ArrayList<Review> getReviews() {
		return reviewsDAO.getReviews();
	}

	public Reviews getReviewsObject() {
		return reviewsDAO.getReviewsObject();
	}
	
	public boolean addReview(Review review) {
		return reviewsDAO.addReview(review);
	}
	
	public boolean deleteReview(Review review) {
		return reviewsDAO.deleteReview(review);
	}
	
	public ArrayList<Review> getReviewsByHotelId(int hotelId) {
		return reviewsDAO.getReviewsByHotelId(hotelId);
	}
	
	public ArrayList<Review> getMyReviewsByAuthorId(int authorId) {
		return reviewsDAO.getMyReviewsByAuthorId(authorId);
	}

	/*******************
	 * AuthorsDAO methods
	 ********************/
	public ArrayList<Author> getAuthors() {
		return authorsDAO.getAuthors();
	}

	public Author getAuthorById(int authorId) {
		return authorsDAO.getAuthorById(authorId);
	}

	public Author getAuthorByCombination(String username, String password) {
		return authorsDAO.getAuthor(username, password);
	}

	public boolean registerAuthor(Author author) {
		return authorsDAO.addAuthor(author);
		
	}

	public Author getAuthorByName(String username) {
		return authorsDAO.getAuthorByName(username);
	}

	

	

	

	

	

	
	
	
}
