<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="${pageContext.request.contextPath}/page.xsl"?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<page title="The Hotels">
	<c:if test="${not empty user }">
		<logged-in-header/>
	</c:if>
	<c:if test="${empty user }">
		<header/>
	</c:if>
	
	<c:if test="${hotels != null}">
	<hotel-list>
		<c:forEach var="hotel" items="${hotels}">
			<hotel id="${hotel.id}" name="${hotel.name}" city="${hotel.city}" country="${hotel.country}"></hotel>
		</c:forEach>
	</hotel-list>
	</c:if>
	<footer/>
</page>