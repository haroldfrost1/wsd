package uts.wsd.DAO;

import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.*;
import uts.wsd.domain.*;

public class HotelsDAO {

	/*
	 * Data Access Object class for
	 * Hotels
	 */
	
	private Hotels hotels;
	private String filePath;
	
	/**
	 * @return the hotels
	 */
	public ArrayList<Hotel> getHotels() {
		return hotels.getHotels();
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	public HotelsDAO() {
		// init with setting filePath to "hotels.xml"will not work!!!
		// 
		
		//initializing
		this.hotels = new Hotels();
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		readHotels();
	}

	public void save(){
		try{
			JAXBContext jc = JAXBContext.newInstance(Authors.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(hotels, new FileOutputStream(filePath));
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readHotels(){
		JAXBContext jc;
		try{
			// ready unmarshaller
			jc = JAXBContext.newInstance(Hotels.class);
			Unmarshaller un = jc.createUnmarshaller();
			
			// Unmarshall from hotels.xml
			FileInputStream fin = new FileInputStream(filePath);
			hotels = (Hotels)un.unmarshal(fin);
			
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
		}
	}

}
