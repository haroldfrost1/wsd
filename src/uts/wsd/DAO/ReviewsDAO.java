package uts.wsd.DAO;

import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.*;
import uts.wsd.domain.*;

public interface ReviewsDAO{
	
	/*
	 * Data Access Object class for
	 * Reviews
	 */
	
	/**************************
	 *  Getters and Setters
	 **************************/
	/*
	 * @return a Reviews object
	 */
	public Reviews getReviewsObject();
	
	/*
	 * @return an ArrayList<Review>
	 */
	public ArrayList<Review> getReviews();
	
	/*
	 * @param int id
	 * @return a Review of specified id
	 */
	public Review getReviewById(int id);
	
	public void setFilePath(String filePath);
	
	
	/*
	 *  @return a list of reviews that belong to the author
	 */
	public ArrayList<Review> getMyReviewsByAuthorId(int authorId);
	
	/*
	 * @return a list of reviews that has the hotel id
	 */
	public ArrayList<Review> getReviewsByHotelId(int hotelId);
	
		
	
	
	/**************************
	 *  Add & Delete Methods
	 **************************/
	public boolean addReview(Review review);
	public boolean deleteReview(Review review);
	
	/*
	 * @return (int)the largest id in the review list
	 */
	public int getLargestId();
	
	
	/**************************
	 * Load and save methods
	 **************************/
	public boolean saved();
	public void readReviews();

	
}
