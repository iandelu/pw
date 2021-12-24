<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="UserBean" scope="session" class="view.UserBean"></jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link href="css/styles.css" rel="stylesheet" type="text/css"/>
		<link href="css/main.css" rel="stylesheet" type="text/css"/>
		<title>JSP Page</title>
	</head>
	<body>
	
	
		<% if (UserBean.getLoginAttempts() >= 3) {
    		response.sendRedirect("http://www.uco.es/");
    	}%>
    	<% if (UserBean.getEmail() != null) { %>
    		<p>Bienvenido <jsp:getProperty property="firstname" name="UserBean"/> <jsp:getProperty property="lastname" name="UserBean"/>
    		(<jsp:getProperty property="email" name="UserBean"/>)
    		</p>
    		<br/>
    		<button type="button" onclick="window.location.href='../controller/user/logoutController.jsp';">Cerrar sesion</button>
    		<button type="button" onclick="window.location.href='../view/user/modifyView.jsp';">Modificar</button>
    	<% } else { %>
		<div class="limiter">
		<div class="container-login100">
			<div class="wrap-registro">

				<form action="../controller/user/loginController.jsp" class="registro-form validate-form text-center" method="post">
					<span class="login100-form-title">
						Login
					</span>
					<div class="form-group text-center">
						<img src="images/usuario1.png" height="80" width="80"/>
						<p><strong>Bienvenidos al sistema</strong></p>
					</div>

                    <div class="wrap-input100 validate-input" data-validate = "Debes introducir un email válido: ejemplo@gmail.com">
						<input class="input100" type="email" name="email" placeholder="Email">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Es necesario una contraseña valida">
						<input class="input100" type="password" name="pass" placeholder="Contraseña">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
					<input class="btn btn-danger btn-block" type="submit" name="action" value="Ingresar">
						
					</div>
                    
  				</form>
			</div>
		</div>
	</div>
	<% } %>
	     <br/>
     <% if (request.getParameter("msg") != null) { %>
  		<p><%= request.getParameter("msg") %>. Le quedan <%= 3 - UserBean.getLoginAttempts() %> intentos. </p>
     <% } %>
	
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</body>
</html>