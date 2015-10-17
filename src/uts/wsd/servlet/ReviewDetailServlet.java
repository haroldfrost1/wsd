package uts.wsd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.wsd.domain.*;
import uts.wsd.facade.*;

public class ReviewDetailServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try{
			Integer id = Integer.parseInt(req.getParameter("id"));

			Service service = new Service();
			Review review = service.getReviewById(id.intValue());
			if (review != null){
				System.out.println("1111111111");
				req.setAttribute("review", review);
				System.out.println(review);
				req.setAttribute("author", service.getAuthorById(review.getAuthorId()));
				req.getRequestDispatcher("WEB-INF/pages/review.jsp").forward(req, resp);
			}
			else{
				String msg = "Review Not Found!";
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
		super.doPost(req, resp);
	}

	
}
