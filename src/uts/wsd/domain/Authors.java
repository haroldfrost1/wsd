package uts.wsd.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "authors")
public class Authors implements Serializable {

	@XmlElement(name = "author")
	private ArrayList<Author> authors;
	
	private int largestId;
	
	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(Author author){
		authors.add(author);
		
		//loop through the list &
		//Update the largest id
		for (Author a : authors){
			if(largestId < a.getId()){
				largestId = a.getId();
			}
		}
	}

	public Authors() {
		this.authors = new ArrayList<Author>();
		this.largestId = 0;
	}
	
	public int getLargestId(){
		return largestId;
	}
	
}
