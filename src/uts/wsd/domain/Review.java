package uts.wsd.domain;

import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "review")
public class Review {
	
	@XmlElement
	private int id;
	
	@XmlElement
	private int hotelId;
	
	@XmlElement
	private int authorId;
	
	@XmlElement
	private int rating;
	
	@XmlElement
	private Date date;
	
	@XmlElement
	private String headline;
	
	@XmlElement
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getHeadline() {
		return headline;
	}


	public void setHeadline(String headline) {
		this.headline = headline;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
