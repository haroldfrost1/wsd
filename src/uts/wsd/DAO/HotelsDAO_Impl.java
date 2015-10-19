package uts.wsd.DAO;

import java.util.ArrayList;

import javax.xml.bind.*;
import java.io.*;

import uts.wsd.domain.Author;
import uts.wsd.domain.Hotel;
import uts.wsd.domain.Hotels;

public class HotelsDAO_Impl implements HotelsDAO{

	public HotelsDAO_Impl() {
		// init with setting filePath to "hotels.xml" will not work!!!
				// 
				
				//initializing
				this.hotels = new Hotels();
				this.setFilePath(this.getClass().getClassLoader().getResource("hotels.xml").getPath());
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
	public boolean saved(){
		try{
			JAXBContext jc = JAXBContext.newInstance(Hotels.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(hotels, new FileOutputStream(filePath));
			return true;
		}
		catch (JAXBException e) {
			e.printStackTrace();
			return false;
		}	
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
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

	@Override
	public Hotel getHotelByName(String hotelname) {
		for (Hotel hotel: getHotels()){
			if (hotel.getName().equals(hotelname))
				return hotel;
		}
		return null;
	}
	
	@Override
	public int getLargestId(){
		//loop through the list &
		//Update the largest id
		int largestId = 0;
		for (Hotel hotel : getHotels()){
			if(largestId < hotel.getId()){
				largestId = hotel.getId();
			}
		}
		return largestId;
	}

	@Override
	public boolean addHotel(Hotel hotel) {
		hotel.setId(getLargestId() +1);
		
		hotels.addHotel(hotel);
		if (saved()){
			return true;
		}
		return false;
	}
}
