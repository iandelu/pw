<!DOCTYPE html>
<html lang="en">
<%@ page import="model.data.Usuario"%>
<%@ page import="model.daos.MySQLDAOManager"%>
<%@ page import="model.data.Espectaculo"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.*"%>
<%@ page import="model.data.Funcion"%>


<head>
<title>Partidos</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<!--===============================================================================================-->
</head>

<header id="main-header">

	<a id="logo-header" href="mainMenuLogged.jsp"> <span
		class="header-pic"><img src="images/icons/logo3.png"></span> <span
		class="site-name">Espectaculos</span>
	</a>

	<nav>
		<ul>
			<li><a href="mainMenuLogged.jsp">Inicio</a></li>
			<li><a href="crearPartido.jsp">Crear Partido</a></li>
		</ul>
	</nav>

</header>
<%
	Espectaculo espectaculoActual = (Espectaculo) session.getAttribute("E");
	Class.forName("com.mysql.jdbc.Driver");
	MySQLDAOManager man = new MySQLDAOManager("", "", "", "");
	ArrayList<Funcion> funciones = (ArrayList<Funcion>) man.getFunciones()
			.obtenerTodosEspectaculo(espectaculoActual.getIdEspectaculo());
%>

<body>
	<br>
	<br>
	<br>
	<div class="search2-page__cards">
		<%
		for (int i = 0; i < funciones.size(); i++) {
		%>
		<div>
			<article class="card">

				<a class="card__header-link"> </a>
				<header class="card__header"
					style="background-image: url(https://media.tacdn.com/media/attractions-splice-spp-674x446/0a/39/7a/16.jpg); margin-top: -5px; width: 101%; margin-left: -2px;">
					<h1>Funcion funciones.get(i).getId +
						funciones.get(i).getFecha.toString() +
						funciones.get(i).getHora().toString() %></h1>
					<h2>
						Localidades Disponibles
						<%=funciones.get(i).getLocalidadesRestantes()%>
					</h2>
				</header>
				<div class="card_body">
					<div class="card_address">
						<div class="card_Adress_street">
							<span class="focus-input100"></span> <i class="fa fa-map"
								aria-hidden="true"></i>
							<h10 style="color: rgb(80, 75, 75);"><%=espectaculoActual.getLocalidadesDisponibles()%></h1>
							<button class="partido-btn" onclick="location.href='home.jsp'">
								¡Boton!</button>
							</form>
						</div>
					</div>
				</div>
			</article>
		</div>

		<%
		}
		%>

	</div>



</body>