package uts.wsd.DAO;

import java.io.*;
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
	public Hotels getHotels() {
		return hotels;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	public HotelsDAO() {
		// initialize filePath to 
		// "hotels.xml"
		setFilePath("hotels.xml");
		readHotels();
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
			
			// Unmarshall from authors.xml
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
