package uts.wsd.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "hotel")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Hotel implements Serializable{

	private int id;
	private String name;
	private String city;
	private String country;
	private String address;
	private String telephone;
	private String email;
	
	public Hotel() {
		
		//initializing every field
		this.id = 0;
		this.name = null;
		this.city = null;
		this.country = null;
		this.address = null;
		this.telephone = null;
		this.email = null;
	}

	public Hotel(int id, String hotelname, String city, String country, String address, String email,
			String telephone) {
		this.id = id;
		this.name = hotelname;
		this.city = city;
		this.country = country;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
