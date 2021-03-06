package uts.wsd.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "authors")
public class Authors implements Serializable {

	
	private ArrayList<Author> authors;
	
	private int largestId;
	
	@XmlElement(name = "author")
	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(Author author){
		authors.add(author);
	}

	public Authors() {
		this.authors = new ArrayList<Author>();
		this.largestId = 0;
	}
	
	public int getLargestId(){
		return largestId;
	}
	
}
