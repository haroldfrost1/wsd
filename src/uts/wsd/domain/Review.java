package uts.wsd.domain;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "review")
public class Review implements Serializable{
	
	
	private int id;
	
	
	private int hotelId;
	
	
	private int authorId;
	
	
	private int rating;
	

	private String date;
	

	private String headline;
	
	
	private String description;
	
	
	public Review() {
		
		//initializing every field
		this.id = 0;
		this.hotelId = 0;
		this.authorId = 0;
		this.rating = 0;
		this.date = null;
		this.headline = null;
		this.description = null;
	}
	
	public Review(int id, int hotelId, int authorId, int rating, String date, String headline, String description){
		this.id = id;
		this.hotelId = hotelId;
		this.authorId = authorId;
		this.rating = rating;
		
		//not sure how to use the Date class,
		//gonna use String for now
		this.date = "2439/4390";
		this.headline = headline;
		this.description = description;
		
	}

	@XmlElement
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	@XmlElement
	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	@XmlElement
	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}

	@XmlElement
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	@XmlElement
	public String getHeadline() {
		return headline;
	}


	public void setHeadline(String headline) {
		this.headline = headline;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
