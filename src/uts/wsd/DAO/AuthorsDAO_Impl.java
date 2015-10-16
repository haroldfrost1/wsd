package uts.wsd.DAO;

import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.*;


import uts.wsd.domain.Author;
import uts.wsd.domain.Authors;

public class AuthorsDAO_Impl implements AuthorsDAO {

	private String filePath;
	private Authors authors;
	
	public AuthorsDAO_Impl() {
		// init with setting filePath to "authors.xml" will not work!!!
				// setFilePath("WebContent/WEB-INF/db/authors.xml");
				// jsp pages will run in a different directory
				
				//initialize authors
				authors = new Authors();
	}
	
	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		readAuthors();
	}
	
	@Override
	public ArrayList<Author> getAuthors(){
		return authors.getAuthors();
	}
	
	@Override
	public Author getAuthorById(int id){
		for (Author author: getAuthors()){
			if (author.getId()==id){
				return author;
			}
		}
		return null;
	}
	
	@Override
	public Author getAuthor(String name, String password){
		for (Author author : getAuthors()){
			if (author.getName().equals(name)){
				if (author.getPassword().equals(password))
					return author;
			}
		}
		return null;
	}
			
	@Override
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
	
	@Override
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
