package uts.wsd.DAO;

import java.util.ArrayList;

import uts.wsd.domain.Review;
import uts.wsd.domain.Reviews;

import javax.xml.bind.*;
import java.io.*;

public class ReviewsDAO_Impl implements ReviewsDAO{

	private String filePath;
	private Reviews reviews;
	
	public ReviewsDAO_Impl() {
				// NEVER init with setting filePath to "reviews.xml" !!!
				// setFilePath("WebContent/WEB-INF/db/reviews.xml"); NOOOO!!!
				
				//initializing
				this.reviews = new Reviews();			
				this.setFilePath(this.getClass().getClassLoader().getResource("reviews.xml").getPath());				
	}
	
	
	
	@Override
	public Reviews getReviewsObject(){
		return this.reviews;
	}
	
	@Override
	public ArrayList<Review> getReviews(){
		return reviews.getReviews();
	}
	
	@Override
	public Review getReviewById(int id){
		for (Review review: getReviews()){
			if (review.getId()==id){
				return review;
			}
		}
		
		return null;
	}
	
	@Override
	public ArrayList<Review> getReviewsByHotelId(int hotelId) {
		ArrayList<Review> result = new ArrayList<Review>();
		
		for (Review review : getReviews()){
			if (review.getHotelId() == hotelId){
				result.add(review);
			}
		}
		
		return result;
	}
	
	@Override
	public ArrayList<Review> getMyReviewsByAuthorId(int authorId){
		ArrayList<Review> myReviews = new ArrayList<Review>();
		
		for (Review review : getReviews()){
			if (review.getAuthorId()==authorId){
				myReviews.add(review);
			}
		}
		
		return myReviews;
	}
	
	@Override
	public void setFilePath(String filePath){
		this.filePath = filePath;
		readReviews();
	}
		
	@Override
	public boolean addReview(Review review){		
		// Setting id to the current largest + 1
		review.setId(getLargestId() + 1);
		
		//add & save
		reviews.addReview(review);
		if (saved()){
			return true;
		}
		return false;
		

	}
	
	@Override
	public int getLargestId(){
		//loop through the list &
		//Update the largest id
		int largestId = 0;
		for (Review r : getReviews()){
			if(largestId < r.getId()){
				largestId = r.getId();
			}
		}
		return largestId;
	}

	@Override
	public boolean deleteReview(Review review){
		reviews.deleteReview(review);
		if (saved()){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean saved(){
		try{
			JAXBContext jc = JAXBContext.newInstance(Reviews.class);
			Marshaller m = jc.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(this.reviews, new FileOutputStream(filePath));
			//m.marshal(reviews, System.out);
			return true;
		}
		catch (JAXBException e) {
			e.printStackTrace();
			return false;
		}	
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public void readReviews(){
		JAXBContext jc;
		try{
			// ready unmarshaller
			jc = JAXBContext.newInstance(Reviews.class);
			Unmarshaller un = jc.createUnmarshaller();
			
			// Unmarshall from reviews.xml
			FileInputStream fin = new FileInputStream(filePath);
			this.reviews = (Reviews)un.unmarshal(fin);
			
			fin.close();
		}
		catch (JAXBException e){
			e.printStackTrace();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}



	

}
