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
				<label for="adType">Tipo</label>
				<select id="adType" class="select-type" name="adType">
					<option value="">Todos</option>
					<option value="General">General</option>
				 	<option value="Puntual">Puntual</option>
					<option value="Pase Múltiple">Pase Múltiple</option>
					<option value="Temporada">Temporada</option>
				</select>
				<br/>
				
				<!-- Espectaculo Puntual -->
				<div style="display: none;" id="puntual-data">
					<label for="startDate">Fecha</label>
					<input type="date" class="input-form" name="startDate">
					<br/>
				</div>
				
				<!-- ANUNCIO TEMATICO -->
				<div style="display: none;" id="multiple-data">
					<p>Seleccione el numero de fechas</p>
					<label for="startDate">Numero</label>
					<input type="number" class="input-form" name="numero">
					<% 
					   int i = 5;
					%>
					<% while(i < 5){ %>
						<label for="startDate">Fecha</label>
						<input type="date" class="input-form" name="startDate">
						<br/>
					<% } i++; %>
				</div>
				
				<!-- Espectaculo Temporada -->
				<div style="display: none;" id="temporada-data">
					<label for="startDate">Fecha de inicio:</label>
					<input type="date" class="input-form" name="startDate">
					<br/>
					<label for="endDate">Fecha de fin:</label>
					<input type="date" class="input-form" name="endDate">
					<label for="startDate">Dia</label>
					<input type="week" class="input-form" name="startDate">
					<br/>
				</div>
				<p>Contenido:</p>
				<textarea name="content" cols="40" rows="5"></textarea>
				<br/>
				<input type="submit" class="small-button" value="Guardar">
			</form>
		</div>
		
		<script>
			document.getElementById("adType").addEventListener("change", function(e) {
				let tipo = e.target.value;
				if (tipo == General) {
					document.getElementById("puntual-data").style.display = "none";
					document.getElementById("multiple-data").style.display = "none";
					document.getElementById("temporada-data").style.display = "none";
				}
				else if (tipo == Puntual) {
					document.getElementById("puntual-data").style.display = "none";
					document.getElementById("multiple-data").style.display = "block";
					document.getElementById("temporada-data").style.display = "none";
				}
				else if (tipo == Pase Múltiple) {
					document.getElementById("puntual-data").style.display = "block";
					document.getElementById("multiple-data").style.display = "none";
					document.getElementById("temporada-data").style.display = "none";
				}
				else if (tipo == Temporada){
					document.getElementById("puntual-data").style.display = "none";
					document.getElementById("multiple-data").style.display = "none";
					document.getElementById("temporada-data").style.display = "block";
				}
			});
		</script>
	</body>
</html>