<%@ page import="model.data.*, java.util.ArrayList, java.time.format.DateTimeFormatter, model.daos.*" %>
<jsp:useBean id="userBean" scope="session" class="view.UserBean"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	MySQLDAOManager man = new MySQLDAOManager("","","","");
	if (userBean.getEmail() == null){
		response.sendRedirect(request.getContextPath());
	}
	Funcion fun;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Resultados de la busqueda</title>
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
	</head>
	<body>
		<%@ include file="../../include/navbar.jsp" %>
		<div class="container-tablon-main">
			<h1>Resultados de la búsqueda</h1>
			<% String titleQuery = (String) request.getAttribute("titulo"); %>
			
			<% String categoria = (String) request.getAttribute("categoria"); %>
			<% DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); %>
			
			<% if (titleQuery != null) { %>
				<p>Resultados que coinciden con "<%= titleQuery %>"</p>
			<% } else if (categoria == null) { %>
				
				<p>Resultados de publicaciones  <%= categoria %></p>
			<% } %>
			
			<% ArrayList<Espectaculo> espectaculos = (ArrayList<Espectaculo>) request.getAttribute("espectaculoSearch"); %>
			
			<% if (espectaculos == null || espectaculos.size() == 0) { %>
				<p>No hay Espectaculos que coincidan con la bussqueda</p>
			<% } else { %>
				<div class="tablon-anuncios">
					<% for (Espectaculo a : espectaculos){ %>
						<div class="anuncio" data-type="<%= a.getTipoEspectaculo() %>">
							<h3><%= a.getTitulo() %></h3>
							<p><%= a.getDescripcion() %></p>
							<p class="small-text">Proxima Funcion
							<%fun = man.getFunciones().obtener(a.getFunciones().get(0));%>
							<% String formattedDate = fun.getFecha().format(formatter); %>
							<%= formattedDate %>
							</p>
						</div>
					<% } %>
				</div>
			<% } %>
		</div>
	</body>
</html>