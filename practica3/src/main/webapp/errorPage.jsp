<!DOCTYPE html>
<html lang="es">
    <head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/styles.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Error</title>
    </head>
    <body>
		<p>ERROR: <%= request.getParameter("msg") %></p>
		<br/>
		<button type="button" onclick="window.location.href='/P2_MVC/';">Volver al inicio</button>
    </body>
</html>