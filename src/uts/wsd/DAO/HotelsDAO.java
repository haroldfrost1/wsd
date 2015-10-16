package uts.wsd.DAO;

import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.*;
import uts.wsd.domain.*;

public interface HotelsDAO{

	/*
	 * Data Access Object class for
	 * Hotels
	 */
		
	/**************************
	 *  Getters and Setters
	 **************************/	
	/**
	 * @return the filePath
	 */
	public String getFilePath();
	public void setFilePath(String filePath);
	
	/**
	 * @return the hotels
	 */
	public ArrayList<Hotel> getHotels();
	public Hotel getHotelById(int id);
	
	
	/**************************
	 * Load and save methods
	 **************************/
	public void save();
	public void readHotels();

}
