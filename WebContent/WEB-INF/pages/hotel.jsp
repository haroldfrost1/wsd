<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="${pageContext.request.contextPath}/page.xsl"?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  
<page title="The Hotels">
	<c:if test="${not empty user }">
		<logged-in-header username="${user.name}"/>
	</c:if>
	<c:if test="${empty user }">
		<header/>
	</c:if>
	
	<c:if test="${hotel != null}">
		<hotel-detail id="${hotel.id}" name="${hotel.name}" city="${hotel.city}" country="${hotel.country}" address="${hotel.address}" email="${hotel.email}" telephone="${hotel.telephone}"></hotel-detail>
		<review-list>
			<c:forEach var="review" items="${reviews }">
			<review id="${review.id}" headline="${review.headline}" rating="${review.rating}" date="${review.date}"></review>
			</c:forEach>
		</review-list>
		<post-form hotel-id="${hotel.id}" msg="${msg}"></post-form>
	</c:if>
		
	<footer/>
	
		
</page>