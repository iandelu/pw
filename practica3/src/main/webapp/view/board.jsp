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
		<title>Tablón de Espectaculos</title>
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
	</head>
	<body>
		<%@ include file="../../include/navbar.jsp" %>
		<% ArrayList<Espectaculo> espectaculos = (ArrayList<Espectaculo>) request.getAttribute("todosEspectaculos"); %>
		<div class="container-tablon-main">
			<h1>Mi tablón de Espectaculos</h1>
			<p>Bienvenido/a <%= userBean.getFirstname() + " " + userBean.getLastname() %></p>
			<div id="container-search-button">
				<button type="button" class="big-button right" onclick="window.location.href='<%= request.getContextPath() %>/MVC/View/search.jsp'">Buscar anuncios</button>
			</div>
			<p>Filtrar anuncios del tablon</p>
			<label>Por tipo:</label>
			<select id="adType" class="select-type" name="adType">
				<option value="">Todos</option>
				<option value="General">General</option>
			 	<option value="Puntual">Puntual</option>
				<option value="Pase Múltiple">Pase Múltiple</option>
				<option value="Temporada">Temporada</option>
			</select>
			<br/>
			<label>Por titulo</label>
			<input type="text" class="input-form" id="filter-title" placeholder="Título">
			<br/>
			<div id="paginate-buttons"></div>
			<% if (espectaculos == null || espectaculos.size() == 0) { %>
				<p>No hay anuncios</p>
			<% } else { %>
				<div class="tablon-anuncios">
					<% for (Espectaculo a : espectaculos){ %>
						<div class="anuncio" data-type="<%= a.getTipoEspectaculo() %>">
							<h3><%= a.getTitulo() %></h3>
							<p><%= a.getDescripcion() %></p>
							<p class="small-text">Proxima Funcion
							<% DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); %>
							<%fun = man.getFunciones().obtener(a.getFunciones().get(0));%>
							<% String formattedDate = fun.getFecha().format(formatter); %>
							<%= formattedDate %>
							</p>
						</div>
					<% } %>
				</div>
			<% } %>
		</div>
		<script type="text/javascript">
			let type = "";
			let title = "";
			
			let adsPerPage = 5;
			let paginatedAds;
			
			// Cargamos el filtrado guardado
			type = localStorage.getItem("filtradoPorTipo");
			if (type == null){
				type = "";
			}
			
			title = localStorage.getItem("filtradoPorTitulo");
			if (title == null){
				title = "";
			}
			
			document.getElementById("adType").value = type;
			document.getElementById("filter-title").value = title;
			
			filter();
			
			// Recarga de la página
			function refresh(){
				location.reload(true);
			}
			setInterval("refresh()", 30000);
			
			function filter(){
				let anuncios = Array.from(document.getElementsByClassName("anuncio"));
				anuncios.forEach(function(element){
					element.style.display = "none";
				});
				
				// Filtro por tipo
				if (type != ""){
					anuncios = anuncios.filter(function(element){
						if (element.getAttribute("data-type") == type){
							return true;
						}
						else{
							return false;
						}
					});
				}
				
				// Filtro por título
				if (title != ""){
					anuncios = anuncios.filter(function(element){
						if (element.children[0].textContent.toLowerCase().includes(title.toLowerCase())){
							return true;
						}
						else{
							return false;
						}
					});
				}
				
				anuncios.forEach(function(element){
					element.style.display = "block";
				});
				paginate();
			}
			
			function paginate(){
				paginatedAds = Array.from(document.getElementsByClassName("anuncio"));
				paginatedAds = paginatedAds.filter(function(element){
					if (element.style.display == "block"){
						return true;
					}
					else{
						return false;
					}
				});
				
				let pages = Math.ceil(paginatedAds.length / adsPerPage);
				
				let html = "";
				
				for (let i = 0; i < pages; i++){
					html += '<button type="button" class="small-button paginate-button right">' + (pages - i) + '</button>';
				}
				document.getElementById("paginate-buttons").innerHTML = html;
				let buttons = document.getElementById("paginate-buttons").children;
				for (let i = 0; i < buttons.length; i++){
					buttons[i].onclick = function(){
						showPagination(pages - i - 1);
					}
					console.log(buttons);
				}
				
				showPagination(0);
			}
			
			function showPagination(start){
				for(let i = 0; i < paginatedAds.length; i++){
					paginatedAds[i].style.display = "none";
				}
				
				let startIndex = start * adsPerPage;
				
				for(let i = startIndex; i < startIndex + adsPerPage; i++){
					if (i >= paginatedAds.length){
						break;
					}
					paginatedAds[i].style.display = "block";
				}
			}
			
			document.getElementById("adType").addEventListener("change", function(e){
				type = e.target.value;
				localStorage.setItem("filtradoPorTipo", type);
				filter();
			});
			
			document.getElementById("filter-title").addEventListener("change", function(e){
				title = e.target.value;
				localStorage.setItem("filtradoPorTitulo", title);
				filter();
			});
			
			
		</script>
	</body>
</html>