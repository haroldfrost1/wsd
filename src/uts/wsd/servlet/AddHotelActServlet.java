package uts.wsd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.wsd.domain.*;
import uts.wsd.facade.*;

public class AddHotelActServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hotelname = req.getParameter("name");
		String city = req.getParameter("city");
		String country = req.getParameter("country");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String telephone = req.getParameter("telephone");
		
		if (!hotelname.equals("")&& !city.equals("") && !country.equals("") && !address.equals("") && !email.equals("") && !telephone.equals("")){
			Service service = new Service();
			if (service.getHotelByName(hotelname) == null){
				Hotel hotel = new Hotel(0, hotelname, city, country, address, email, telephone);
				if (service.addHotel(hotel)){
					resp.sendRedirect("index.jsp");
				}
				else {
					resp.sendRedirect("addhotel.jsp?msg=Error encountered while saving.");
				}
			}
			else{
				resp.sendRedirect("addhotel.jsp?msg=Hotel already exists.");
			}
		}
		else{
			resp.sendRedirect("addhotel.jsp?msg=All fields are mandatory.");
		}
	}

}
