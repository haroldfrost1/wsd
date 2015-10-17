package uts.wsd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.wsd.facade.*;
import uts.wsd.domain.*;

public class HotelDetailServlet extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);
		try{
		Integer id = Integer.parseInt(req.getParameter("id"));
		Service service = new Service();
		Hotel hotel = service.getHotelById(id.intValue());

		if (hotel != null){
			req.setAttribute("hotel", service.getHotelById(id));
			req.setAttribute("reviews", service.getReviewsByHotelId(id));
			req.getRequestDispatcher("WEB-INF/pages/hotel.jsp").forward(req, resp);
		}
		else {
			String msg = "Hotel Not Found!";
			resp.sendRedirect("/error.jsp?msg=" + msg);
		}
		}
		catch(NumberFormatException e){
			String msg = "Please send a paramter id!";
			resp.sendRedirect("/error.jsp?msg=" + msg);
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
