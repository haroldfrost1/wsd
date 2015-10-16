<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="page.xsl"?>
<%@ page import="uts.wsd.domain.Author" %>
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
		Author author = (Author)session.getAttribute("author");
		if (author != null){
	%>
	<my-review-list>
	<% for (Review review : reviewsApp.getMyReviewsByAuthorId(author.getId())){ %>
		<my-review id="<%= review.getId()%>" headline="<%= review.getHeadline()%>" date="<%= review.getDate()%>"></my-review>
	<% } %>
	</my-review-list>
	<% } %>
</page>