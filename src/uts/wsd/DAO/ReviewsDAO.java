package uts.wsd.DAO;

import java.io.*;
import javax.xml.bind.*;
import uts.wsd.domain.*;

public class ReviewsDAO {
	
	/*
	 * Data Access Object class for
	 * Reviews
	 */
	
	private String filePath;
	private Reviews reviews;
	
	
	public ReviewsDAO() {
		// init with setting filePath to
		// "reviews.xml"
		setFilePath("reviews.xml");
		readReviews();
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
		
	public void addReview(Review review){
		readReviews();
		
		//Setting id to the current largest + 1
		review.setId(reviews.getLargestId() + 1);
		
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
			JAXBContext jc = JAXBContext.newInstance(Authors.class);
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
			
			// Unmarshall from authors.xml
			FileInputStream fin = new FileInputStream(filePath);
			reviews = (Reviews)un.unmarshal(fin);
			
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
