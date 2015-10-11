<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" import="uts.wsd.domain.Review" %><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="page.xsl"?>
<%@ page import="uts.wsd.domain.Author" %>
<%
	String reviewsFilePath = application.getRealPath("WEB-INF/db/reviews.xml");
    String authorsFilePath = application.getRealPath("WEB-INF/db/authors.xml");
%>
<!-- use ReviewsDAO bean and read the reviews from filePath -->
<jsp:useBean id="reviewsApp" class="uts.wsd.DAO.ReviewsDAO" scope="application">
	<jsp:setProperty name="reviewsApp" property="filePath" value="<%=reviewsFilePath%>" />
</jsp:useBean>

<!-- use ReviewsDAO bean and read the reviews from filePath -->
<jsp:useBean id="authorsApp" class="uts.wsd.DAO.AuthorsDAO" scope="application">
	<jsp:setProperty name="authorsApp" property="filePath" value="<%=authorsFilePath%>" />
</jsp:useBean>
<%
	int id = Integer.parseInt(request.getParameter("id"));
    Review review = reviewsApp.getReviewById(id);
    Author author = authorsApp.getAuthorById(review.getAuthorId());
%>

<page>
	<header></header>
	<review-detail id="<%= review.getId()%>" author-name="<%=author.getName()%>" description="<%=review.getDescription()%>" headline="<%=review.getHeadline()%>" rating="<%=review.getRating() %>" hotelname="<%=request.getAttribute("hotelname")%>"></review-detail>
	<footer></footer>
</page>
