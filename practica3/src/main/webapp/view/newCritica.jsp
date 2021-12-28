<%@ page import="model.data.*, java.util.ArrayList, java.time.format.DateTimeFormatter, model.daos.*" %>
<jsp:useBean id="userBean" scope="session" class="view.UserBean"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%
	if (userBean.getEmail() == null){
		response.sendRedirect(request.getContextPath());
	}
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="ISO-8859-1">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
	    <title>Nuevo anuncio</title>
	</head>
	<body>
		<%@ include file="../../include/navbar.jsp" %>
		<div class="container-tablon-main">
			<h1>Crear anuncio</h1>
			<form action="<%= request.getContextPath() %>/newAdServlet" method="post">
				<label for="title">Título:</label>
				<input type="text" class="input-form" name="title">
				<br/>
				<label for="text">Texto:</label>
				<input type="text" class="input-form" name="title">
				<br/>
				<label for="puntuacion">Puntuacion</label>
				<input type="number" class="input-form" name="title">
				<br/>	
			</form>
		</div>
	</body>
</html>