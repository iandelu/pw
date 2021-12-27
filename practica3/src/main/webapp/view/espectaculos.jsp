
<!DOCTYPE html>
<html lang="en">
<%@ page import = "model.data.Usuario" %>
<%@ page import = "model.data.*" %>
<%@ page import = "model.daos.MySQLDAOManager" %>
<%@ page import = "java.util.ArrayList" %>

<jsp:useBean id="jugadorBean" class = "view.UserBean" scope="session"/>
<head>
<%
	Usuario usuario = (Usuario) session.getAttribute("jugador");
	Class.forName("com.mysql.jdbc.Driver");
	MySQLDAOManager man = new MySQLDAOManager("ggather.zapto.org", "java", "1234", "aplicacion");
	ArrayList<Espectaculo> espectaculos = man.getEspectaculos().obtenerTodos();
%>
<body>

	<div class="limiter">
		<div class="container-menuPerfil">
			<div class="wrap-menuPerfil">
				<div class="menuPerfil-pic js-tilt" data-tilt>
					<img src="images/icons/mankuco.PNG" alt="IMG">
				</div>
				<span class="login100-form-title"> <BR> Historial de
					partidos de @<%=usuario.getUsuario()%>
				</span>



				<div class="search2-page__cards">
					<%
					for (int i = 0; i < espectaculos.size(); i++) {
					%>

					<div>
						<article class="card">
							<a class="card__header-link"> </a>
							<header class="card__header"
								style="background-image: url(&quot;https://openarena.es/wp-content/uploads/2019/05/open_arena_instalaciones16.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
								<h1>
									Partido de @
									<%=%></h1>
								<h2><%=%>
								</h2>
							</header>
							<div class="card_body">
								<div class="card_address">
									<div class="card_Adress_street">
										<span class="focus-input100"></span> <i class="fa fa-calendar"
											aria-hidden="true"></i> <span
											style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;">
											<%=man.getReservaDAO().obtener(partidos.get(i).getReserva()).getFecha()%>
										</span> <i class="fa fa-clock-o" aria-hidden="true"></i> <span
											style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;">
											<%=man.getReservaDAO().obtener(partidos.get(i).getReserva()).getHoraInicio()%></span>
									</div>
								</div>
								<div class="slots">
									<a>
										<div>
											<button class="partido-btn"
												onclick="location.href='partido.jsp'">Ver Detalles
											</button>

										</div>
									</a>
								</div>
							</div>
						</article>
					</div>
					<%
					}
					%>


					<div class="text-center p-t-30">
						<a class="txt2" onclick="location.href='menuPerfil.html'">
							Volver al mi perfil <i class="fa fa-long-arrow-right m-l-5"
							aria-hidden="true"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
</body>
</html>