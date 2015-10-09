package uts.wsd.domain;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Author {

	/*
	 * Strictly stick to the following xml format
	 * 
	 * <author>
	 * 	<id></id>
	 * 	<name></name>
	 * 	<password></password>
	 * 	<email></email>
	 * </author>
	 */
	
	@XmlElement
	private int id;
	
	@XmlElement
	private String name;
	
	@XmlElement
	private String password;
	
	@XmlElement
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public Author() {
		
		//initializing every field
		this.id = 0;
		this.name = null;
		this.password = null;
		this.email = null;
	}

}
