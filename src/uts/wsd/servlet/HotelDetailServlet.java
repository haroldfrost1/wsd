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
			
			int id = Integer.parseInt(req.getParameter("id"));
			Service service = new Service();
			Hotel hotel = service.getHotelById(id);

			if (hotel != null){
				// Get sent back message from post review form
				String msg = req.getParameter("msg");
				String success = req.getParameter("success");
				req.setAttribute("success", success);
				req.setAttribute("msg", msg);
				
				// Retrieve Hotel Detail data
				req.setAttribute("hotel", service.getHotelById(id));
				
				req.setAttribute("reviews", service.getReviewsByHotelId(hotel.getId()));
				req.getRequestDispatcher("WEB-INF/pages/hotel.jsp").forward(req, resp);
			}
			else {
				// Hotel Not Found
				String msg = "Hotel Not Found!";
				resp.sendRedirect("error.jsp?msg=" + msg);
			}
		}
		catch(NumberFormatException e){
			// Handle no parameter id is sent
			String msg = "Please send a paramter id!";
			resp.sendRedirect("error.jsp?msg=" + msg);
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
