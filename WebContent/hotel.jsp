<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="page.xsl"?>
<%@ page import="uts.wsd.domain.Hotel" %>
<%@ page import="uts.wsd.domain.Review" %>
<%@ page import="uts.wsd.domain.Author" %>
<%	
	//retrieve "real" path
	//since the jsp page is running in a different directory from the classes
	//So you can't hard-code the filePath in the class
	String hotelsFilePath = application.getRealPath("WEB-INF/db/hotels.xml");
	String reviewsFilePath = application.getRealPath("WEB-INF/db/reviews.xml");
	Author author = (Author)session.getAttribute("author");
%>

<!-- use HotelsDAO bean and read the hotels from filePath -->
<jsp:useBean id="hotelsApp" class="uts.wsd.DAO.HotelsDAO" scope="application">
	<jsp:setProperty name="hotelsApp" property="filePath" value="<%=hotelsFilePath%>" />
</jsp:useBean>

<!-- use ReviewsDAO bean and read the reviews from filePath -->
<jsp:useBean id="reviewsApp" class="uts.wsd.DAO.ReviewsDAO" scope="application">
	<jsp:setProperty name="reviewsApp" property="filePath" value="<%=reviewsFilePath%>" />
</jsp:useBean>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	Hotel hotel = hotelsApp.getHotelById(id);
	
%>
  
<page title="The Hotels">
	<%
		if (author==null){
	%>
	<header/>
		<!-- display header here  -->
	<%
		} else {
	%>
	<logged-in-header username="<%=author.getName()%>"/>
		<!-- display header here  -->
	<%		
		}
	%>
	
	<!-- display hotel details -->
	<hotel-detail id="<%= hotel.getId()%>" name="<%= hotel.getName()%>" city="<%= hotel.getCity()%>" country="<%=hotel.getCountry()%>" address="<%= hotel.getAddress()%>" email="<%=hotel.getEmail()%>" telephone="<%=hotel.getTelephone()%>"></hotel-detail>
	
	<!-- display review headlines -->
	<review-list>
		<% for (Review review: reviewsApp.getReviews()){
			if (review.getHotelId()==hotel.getId()){
		%>
		<review id="<%=review.getId()%>" headline="<%=review.getHeadline()%>" date="<%=review.getDate()%>" star="<%=review.getRating()%>" hotelname="<%=hotel.getName()%>"></review>
		<% 
			}
		} 
		%>
	</review-list>
	<post-review-link/>
	<footer/>
		
</page>