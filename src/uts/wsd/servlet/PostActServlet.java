package uts.wsd.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.wsd.domain.*;
import uts.wsd.facade.*;

public class PostActServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Author user = (Author)req.getSession().getAttribute("user");
		try{
			int hotelId = Integer.parseInt(req.getParameter("hotelId"));
			if (user != null){
				String headline = req.getParameter("headline");
				String description = req.getParameter("description");
				int rating = Integer.parseInt(req.getParameter("rating"));

				if (!headline.equals("") && !description.equals("")){
					Review review = new Review(0, hotelId, user.getId(), rating, new Date(), headline, description);
					Service service = new Service();
					service.addReview(review);
					resp.sendRedirect("hotel.jsp?id=" + hotelId + "&success=Successfully posted review!");
				}
				else {
					resp.sendRedirect("hotel.jsp?id=" + hotelId +"&msg=Please write something, mate. I don't like blank reviews");
				}
			}
			else {
				resp.sendRedirect("hotel.jsp?id=" + hotelId +"&msg=Please Login to post a review.");
			}
		}
		catch (NumberFormatException e){
			resp.sendRedirect("error.jsp?msg=" + e.getLocalizedMessage());
		}
	}

}
