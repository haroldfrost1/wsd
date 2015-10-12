<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="page.xsl"?>
<%@ page import="uts.wsd.domain.Hotel"%>
<%
	String hotelsFilePath = application.getRealPath("WEB-INF/db/hotels.xml");
	int hotelId = Integer.parseInt(request.getParameter("hotelId"));
%>

<!-- use HotelsDAO bean and read the hotels from filePath -->
<jsp:useBean id="hotelsApp" class="uts.wsd.DAO.HotelsDAO" scope="application">
	<jsp:setProperty name="hotelsApp" property="filePath" value="<%=hotelsFilePath%>" />
</jsp:useBean>

<page>
	<% Hotel hotel = hotelsApp.getHotelById(hotelId);%>
	
	<post-review-form hotel-name="<%=hotel.getName()%>" hotel-id="<%=hotelId%>"/>
</page>