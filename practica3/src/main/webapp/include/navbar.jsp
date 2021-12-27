<header class="navbar">
	<ul class="navbar-left">
		<li class="navbar-item">
			<a href="<%=request.getContextPath()%>/boardServlet">Tablón</a>
		</li>
		<li class="navbar-item">
			<a href="<%=request.getContextPath()%>/newAdServlet">Nuevo anuncio</a>
		</li>
		<li class="navbar-item">
			<a href="<%=request.getContextPath()%>/myAdsServlet">Mis anuncios</a>
		</li>
		
	</ul>
	<ul class="navbar-right">
		<li class="navbar-item">
			<a href="<%=request.getContextPath()%>/MVC/View/editProfile.jsp">Editar perfil</a>
		</li>
		<li class="navbar-item" style="background-color: #db2121;">
			<a href="<%= request.getContextPath() %>/logoutServlet">Cerrar sesion</a>
		</li>
	</ul>
</header>