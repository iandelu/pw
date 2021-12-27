<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Busqueda</title>
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
	</head>
	<body>
		<%@ include file="../include/navbar.jsp" %>
		<div class="container-tablon-main">
			<h1>Buscar anuncio</h1>
			<p>Buscar por titulo</p>
			<% String msg = (String)request.getAttribute("errorMsg"); // Mensaje de respuesta %>
	    	<% if (msg != null) { %>
	    		<p class="message-error-left"><%= msg %></p>
	    	<% } %>
			<form action="<%= request.getContextPath() %>/searchServlet" method="get">
				<input type="hidden" name="type" value="title">
				<input type="text" class="input-form" name="titleQuery">
				<input type="submit" class="small-button" value="Buscar">
			</form>
			<p>Buscar por Categoria</p>
			<form action="<%= request.getContextPath() %>/searchServlet" method="get">
				<input type="hidden" name="type" value="dateRange">
				<label for="categoria">Categoria</label>
				<input type="text" class="input-form" name="categoria">
			</form>
		</div>
	</body>
</html>