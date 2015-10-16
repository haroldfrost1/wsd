package uts.wsd.DAO;



import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.*;

import uts.wsd.domain.*;

public interface AuthorsDAO{
	/*
	 * Data Access Object interface for
	 * Authors
	 */
	
	/**************************
	 *  Getters and Setters
	 **************************/
	/*
	 * @param filePath
	 * Set file path
	 */
	public void setFilePath(String filePath);
	
	public ArrayList<Author> getAuthors();
	
	/*
	 * @param int id 
	 * @return an Author of specified id
	 */
	public Author getAuthorById(int id);
	
	/*
	 * Login method
	 * @param String name, String password
	 * @return an Author matches the combination
	 */
	public Author getAuthor(String name, String password);
			
	/**************************
	 * Load and save methods
	 **************************/
	public void save();
	public void readAuthors();
	

}
