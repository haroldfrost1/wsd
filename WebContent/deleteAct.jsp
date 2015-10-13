<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="page.xsl"?>
<%@ page import="uts.wsd.domain.Review" %>
<%
 	String reviewsFilePath = application.getRealPath("WEB-INF/db/reviews.xml");
%>
<!-- use ReviewsDAO bean and read the reviews from filePath -->
<jsp:useBean id="reviewsApp" class="uts.wsd.DAO.ReviewsDAO" scope="application">
	<jsp:setProperty name="reviewsApp" property="filePath" value="<%=reviewsFilePath%>" />
</jsp:useBean>

<page>
	<% 
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		Review review = reviewsApp.getReviewById(reviewId);
		reviewsApp.deleteReview(review);
	%>
	<delete-message></delete-message>
</page>