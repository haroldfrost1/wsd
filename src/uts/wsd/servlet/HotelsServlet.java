package uts.wsd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.wsd.facade.*;
import uts.wsd.domain.*;

public class HotelsServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 *  Main page. Retrieve Hotel Data
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// super.doGet(req, resp);
		req.setAttribute("admin", 0);
		
		
		Service service = new Service();
		
		// Getting logged in user
		Author user = (Author)req.getSession().getAttribute("user");
		
		// Check if he is the admin
		if (user != null){
			if (user.getName().equals("admin")){
				req.setAttribute("admin", 1);
			}
		}
		
		// set attribute
		req.setAttribute("hotels", service.getHotels());
		
		// forward the data to the page
		req.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPost(req, resp);
	}
	
}
