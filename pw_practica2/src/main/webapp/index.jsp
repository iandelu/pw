<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link href="css/styles.css" rel="stylesheet" type="text/css"/>
		<title>JSP Page</title>
	</head>
	<body>
		<div class="container col-lg-3">
			<form action="Principal.jsp">
				<div class="form-group text-center">
					<img src="images/usuario1.jpg" height="80" width="80"/>
					<p><strong>Bienvenidos al sistema</strong></p>
				</div>
				<div class="form-group">
					<label>Nombre</label>
					<input class="form-control" type="text" name="txtnom" placeholder="Ingrese Nombre">
				</div>
				<div class="form-group">
					<label>Email</label>
					<input class="form-control" type="email" name="txtemail" placeholder="example@gmail.com" >
				</div>
				<input class="btn btn-danger btn-block" type="submit" name="action" value="Ingresar">
			
			</form>
		</div>
	
	
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</body>
</html>