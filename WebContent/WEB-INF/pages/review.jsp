<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml-stylesheet type="text/xsl" href="${pageContext.request.contextPath}/page.xsl"?>

<page title="Review Detail Page">
	<c:if test="${not empty user }">
		<logged-in-header/>
	</c:if>
	<c:if test="${empty user }">
		<header/>
	</c:if>
	
	<c:if test="${review != null }">
	<review id="${review.id}" author-name="${author.name}" description="${review.description}" headline="${review.headline}" rating=""${review.rating}" date="${review.date}"/>
	</c:if>
	<footer/>
</page>