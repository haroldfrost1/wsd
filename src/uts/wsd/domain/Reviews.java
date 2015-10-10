package uts.wsd.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "reviews")
public class Reviews implements Serializable{

	
	private ArrayList<Review> reviews;
	
	private int largestId;
	
	@XmlElement(name = "review")
	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public Reviews() {
		reviews = new ArrayList<Review>();
	}
	
	public void addReview(Review review){
		reviews.add(review);
		
		//loop through the list &
		//Update the largest id
		for (Review r : reviews){
			if(largestId < r.getId()){
				largestId = r.getId();
			}
		}
	}
	
	public void deleteReview(Review review){
		reviews.remove(review);
	}
	
	public int getLargestId(){
		return largestId;
	}

}
