<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="page.xsl"?>
<%@ page import="uts.wsd.domain.Author"%>
<%
	String authorsFilePath = application.getRealPath("WEB-INF/db/authors.xml");
%>

<!-- use HotelsDAO bean and read the hotels from filePath -->
<jsp:useBean id="authorsApp" class="uts.wsd.DAO.AuthorsDAO" scope="application">
	<jsp:setProperty name="authorsApp" property="filePath" value="<%=authorsFilePath%>" />
</jsp:useBean>

<page>
	<%
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		Author author = authorsApp.getAuthor(username, password);
		if (author!=null){
			session.setAttribute("author", author);
	%>
	<welcome  username="<%=username%>"/>
	<%
		} else {
	%>
	<loggin-fail/>
	<%		
		}
	%>
</page>
