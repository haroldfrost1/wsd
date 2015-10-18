package uts.wsd.servlet;

import uts.wsd.domain.Author;
import uts.wsd.facade.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginActServlet extends HttpServlet {

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
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (!username.equals("")&&!password.equals("")){
			Service service = new Service();
			Author user = service.getAuthorByCombination(username,password);
			if (user != null){
				req.getSession().setAttribute("user", user);
				resp.sendRedirect("index.jsp");
			}
			else {
				String msg = "Incorrect input of username or password. Please try again";
				resp.sendRedirect("login.jsp?msg=" + msg);
			}
		}
		else{
			String msg = "Please type your name and password, mate.";
			resp.sendRedirect("login.jsp?msg=" + msg);
		}
	}

	
}
