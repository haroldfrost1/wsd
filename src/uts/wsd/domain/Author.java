package uts.wsd.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Author implements Serializable{

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
	
	
	private int id;
	
	
	private String name;
	
	
	private String password;
	

	private String email;
	
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
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElement
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
	
	public Author(int id, String name, String password, String email){
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

}
