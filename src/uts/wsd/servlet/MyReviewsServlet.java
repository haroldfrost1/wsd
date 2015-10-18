package uts.wsd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.wsd.domain.*;
import uts.wsd.facade.*;
public class MyReviewsServlet extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service service = new Service();
		Author user = (Author)req.getSession().getAttribute("user");
		
		if (user != null){
			ArrayList<Review> myReviews = service.getMyReviewsByAuthorId(user.getId());
			req.setAttribute("myReviews", myReviews);
			req.getRequestDispatcher("WEB-INF/pages/myReviews.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect("error.jsp?msg=Please Login First!");
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
