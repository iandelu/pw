<jsp:useBean id="customerBean" scope="session" class="display.CustomerBean"></jsp:useBean>
<!DOCTYPE html>


<html lang = "es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<title>JSP Page</title>
	</head>
	<body>
	
	
		<% if (customerBean.getEmail() != null) { %>
			
			<button type="button" onclick="window.location.href='view/user/modifyView.jsp';">Configuracion</button>
			<nav class="navbar navbar-dark bg-dark">
			<a style="color: white" class="navbar-toggler"><span class="navbar-toggler-icon"></span>Home</a>
			<div class="dropdown">
				<button type="button" onclick="window.location.href='controller/user/logoutController.jsp';">Salir</button>	
				<div class="dropdown-menu" text-center>
					<a><img alt="imagen usuario" src="images/usuario1.jpg" height="80" width="80"></a><br>
					<a><%=customerBean.getNombre() %></a>
					<a><%=customerBean.getEmail() %></a>
					<div class="dropdown-divider"></div>
					<a href="index.jsp" class="dropdown-item">Salir</a>
				</div>
			</div>
		</nav>
		<div class="container mt-4">
			<h3>Bienvenido al sistema.....<strong><%=customerBean.getNombre() + customerBean.getApellidos%></strong></h3>
		
		</div>
	 	<% } else { %>
			<button type="button" onclick="window.location.href='view/user/login.jsp';">Iniciar sesion</button>
			<button type="button" onclick="window.location.href='view/user/singup.jsp';">Registrarse</button>
	  	<% } %>        

		
	
	
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</body>
</html>