package uts.wsd.DAO;

import java.util.ArrayList;

import javax.xml.bind.*;
import java.io.*;

import uts.wsd.domain.Hotel;
import uts.wsd.domain.Hotels;

public class HotelsDAO_Impl implements HotelsDAO{

	public HotelsDAO_Impl() {
		// init with setting filePath to "hotels.xml" will not work!!!
				// 
				
				//initializing
				this.hotels = new Hotels();
	}
	
	private Hotels hotels;
	private String filePath;
	
	
	@Override
	public String getFilePath() {
		return filePath;
	}
	
	@Override
	public ArrayList<Hotel> getHotels() {
		return hotels.getHotels();
	}
	
	@Override
	public Hotel getHotelById(int id){
		for (Hotel hotel: getHotels()){
			if (hotel.getId() == id){
				return hotel;
			}
		}
		return null;
	}
	
	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		readHotels();
	}

	@Override
	public void save(){
		try{
			JAXBContext jc = JAXBContext.newInstance(Hotels.class);
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

	@Override
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
