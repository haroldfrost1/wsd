package uts.wsd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.wsd.domain.*;
import uts.wsd.facade.*;

public class RegisterActServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		 
		
		if (!username.equals("") && !password.equals("") && !email.equals("")){
			Service service = new Service();
				Author author = service.getAuthorByName(username);
			if (author == null){
				author = new Author(0, username, password, email);
				if (service.registerAuthor(author)){
					req.getSession().setAttribute("user", author);
					resp.sendRedirect("index.jsp");
				}
				else{
					resp.sendRedirect("register.jsp?msg=Invalid email format.");
				}
			}
			else{
				resp.sendRedirect("register.jsp?msg=Username already exists.");
			}
		}
		else {
			resp.sendRedirect("register.jsp?msg=All fields are mandatory.");
		}
	}

}
