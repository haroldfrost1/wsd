<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="${pageContext.request.contextPath}/page.xsl"?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<page title="Review Detail Page">
	<c:if test="${not empty user }">
		<logged-in-header/>
	</c:if>
	<c:if test="${empty user }">
		<header/>
	</c:if>
	
	<c:if test="${review != null }">
	<review-detail id="${review.id}" headline="${review.headline}" author-name="${author.name}" date="${review.date}" description="${review.description}" rating="${review.rating}"/>
	</c:if>
	<footer/>
</page>