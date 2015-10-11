<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" import="uts.wsd.DAO.HotelsDAO" %><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="page.xsl"?>
<%@ page import="uts.wsd.domain.Hotel" %>
<%@ page import="uts.wsd.domain.Author" %>
<%	
	// retrieve "real" path
	// since the jsp page is running in a different directory from the classes
	// So you can't hard-code the filePath in the class
	String hotelsFilePath = application.getRealPath("WEB-INF/db/hotels.xml");

	// get author in session
	// session.setAttribute("author", new Author(3, "Gwen", "Gwen", "Gwen@fake.com")); // for testing purpose
	Author author = (Author)session.getAttribute("author");
%>

<!-- use HotelsDAO bean and read the hotels from filePath -->
<jsp:useBean id="hotelsApp" class="uts.wsd.DAO.HotelsDAO" scope="application">
	<jsp:setProperty name="hotelsApp" property="filePath" value="<%=hotelsFilePath%>" />
</jsp:useBean>
  
<page title="The Hotels">
	<%
		if (author==null){
	%>
	<header>
		<!-- display header here  -->
	</header>
	<%
		} else {
	%>
	<logged-in-header>
		<!-- display header here  -->
	</logged-in-header>
	<%		
		}
	%>
	<hotel-list>
		<% for (Hotel hotel: hotelsApp.getHotels()){%>
		<hotel id="<%= hotel.getId()%>" name="<%= hotel.getName()%>" city="<%= hotel.getCity()%>" country="<%= hotel.getCountry()%>"/>
		<% } %>
	</hotel-list>
	<footer>
		<!-- display footer here  -->
	</footer>
</page>