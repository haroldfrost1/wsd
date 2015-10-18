<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="${pageContext.request.contextPath}/page.xsl"?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<page>
	<c:if test="${not empty user }">
		<logged-in-header username="${user.name}"/>
	</c:if>
	<c:if test="${empty user }">
		<header/>
	</c:if>
	
	<c:if test="${myReviews != null}">
	<my-review-list>
		<c:forEach var="review" items="${myReviews}">
			<my-review id="${review.id}" author-name="${author.name}" description="${review.description}" headline="${review.headline}" rating=""${review.rating}" date="${review.date}"></my-review>
		</c:forEach>
	</my-review-list>
	</c:if>
</page>