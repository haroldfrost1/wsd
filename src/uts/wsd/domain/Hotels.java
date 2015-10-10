package uts.wsd.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "hotels")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Hotels implements Serializable{
	private ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	
	public Hotels() {
		
	}

	@XmlElement(name = "hotel")
	public ArrayList<Hotel> getHotels() {
		return hotels;
	}
	
	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	

}
