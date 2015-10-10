package uts.wsd.DAO;

import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.*;
import uts.wsd.domain.*;

public class ReviewsDAO implements Serializable{
	
	/*
	 * Data Access Object class for
	 * Reviews
	 */
	
	private String filePath;
	private Reviews reviews;
	
	
	public ReviewsDAO() {
		// init with setting filePath to "reviews.xml" !!!
		// setFilePath("WebContent/WEB-INF/db/reviews.xml"); NOOOO!!!
		
		//initializing
		this.reviews = new Reviews();
		
		
	}
	
	public ArrayList<Review> getReviews(){
		return reviews.getReviews();
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
		readReviews();
	}
		
	public void addReview(Review review){
		//readReviews();
		
		//Setting id to the current largest + 1
		//review.setId(reviews.getLargestId() + 1);
		
		//add & save
		reviews.addReview(review);
		save();
	}
	
	public void deleteReview(Review review){
		readReviews();
		reviews.deleteReview(review);
		save();
	}
	
	public void save(){
		try{
			JAXBContext jc = JAXBContext.newInstance(Reviews.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(reviews, new FileOutputStream(filePath));
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

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
			// TODO: handle exception
		}
	}
}
