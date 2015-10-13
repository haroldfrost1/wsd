<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="page.xsl"?>
<%@ page import="uts.wsd.domain.Review"%>
<%@ page import="uts.wsd.domain.Author"%>
<%
 	String reviewsFilePath = application.getRealPath("WEB-INF/db/reviews.xml");
%>

<!-- use ReviewsDAO bean and read the reviews from filePath -->
<jsp:useBean id="reviewsApp" class="uts.wsd.DAO.ReviewsDAO" scope="application">
	<jsp:setProperty name="reviewsApp" property="filePath" value="<%=reviewsFilePath%>" />
</jsp:useBean>


<page>
	<%
	// Get logged in author
	Author author = (Author)session.getAttribute("author");
	if (author != null) {
		// Getting all parameters from the form
		String headline = request.getParameter("headline");
		String description = request.getParameter("description");
		String hotelname = request.getParameter("hotelname");
		int star = Integer.parseInt(request.getParameter("star"));
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		String date = "11/11/2011";
		
		Review review = new Review(0, hotelId, author.getId(), star, date, headline, description);
		reviewsApp.addReview(review);

	}
%>
	<post-act/>
</page>