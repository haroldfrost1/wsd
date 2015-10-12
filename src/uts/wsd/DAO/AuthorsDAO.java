package uts.wsd.DAO;



import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.*;

import uts.wsd.domain.*;

public class AuthorsDAO implements Serializable{
	/*
	 * Data Access Object class for
	 * Authors
	 */
	
	
	private String filePath;
	private Authors authors;
	
	public AuthorsDAO() {
		// init with setting filePath to "authors.xml" will not work!!!
		// setFilePath("WebContent/WEB-INF/db/authors.xml");
		// jsp pages will run in a different directory
		
		//initialize authors
		authors = new Authors();
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		readAuthors();
	}
	
	public ArrayList<Author> getAuthors(){
		return authors.getAuthors();
	}
	
	public Author getAuthorById(int id){
		for (Author author: getAuthors()){
			if (author.getId()==id){
				return author;
			}
		}
		return null;
	}
	
	public Author getAuthor(String name, String password){
		for (Author author : getAuthors()){
			if (author.getName().equals(name)){
				if (author.getPassword().equals(password))
					return author;
			}
		}
		return null;
	}
			
	public void save(){
		try{
			JAXBContext jc = JAXBContext.newInstance(Authors.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(authors, new FileOutputStream(filePath));
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readAuthors(){
		JAXBContext jc;
		try{
			// ready unmarshaller
			jc = JAXBContext.newInstance(Authors.class);
			Unmarshaller un = jc.createUnmarshaller();
			
			// Unmarshall from authors.xml
			FileInputStream fin = new FileInputStream(filePath);
			authors = (Authors)un.unmarshal(fin);
			
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
	
//	We don't need this function yet 
//	
//	public void addAuthor(Author author){
//		
//		readAuthors();
//		
//		// Setting author id with current largest id +1
//		author.setId(authors.getLargestId() + 1);
//		
//		//add & save
//		authors.addAuthor(author);
//		save();
//	}

}
