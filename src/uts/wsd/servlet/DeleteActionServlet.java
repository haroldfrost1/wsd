package uts.wsd.servlet;

import uts.wsd.facade.*;
import uts.wsd.domain.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteActionServlet extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Integer id = Integer.parseInt(req.getParameter("id"));
			
			Service service = new Service();
			Author user = (Author)req.getSession().getAttribute("user");
			
			// Check if the user is logged-in
			if (user != null){
				Review review = service.getReviewById(id);
				
					// Check if the review exists
					if (review != null){
						
						// Check if the user is the author of the review
						if (review.getAuthorId() == user.getId()){
							service.deleteReview(review);
							resp.sendRedirect("myReviews.jsp");
						}
						else {
							
							// if not, no permission to delete
							String msg = "You are not the author of this review. You don't have permission to delete it.";
							resp.sendRedirect("error.jsp?msg=" + msg);
						}
					}
					else{
						// if review not found
						String msg = "Review not found!";
						resp.sendRedirect("error.jsp?msg=" + msg);
					}
				
			}
			else {
				// You have to log in first, you know
				String msg = "Please Login First";
				resp.sendRedirect("error.jsp?msg=" + msg);
			}
				
		}
		catch (NumberFormatException e){
			String msg = "Please send a parameter id.";
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
