<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="code_utile/dataInit.jsp" %>				
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IGA - La ou votre argent est notre ami</title>

<!-- JAVASCRIPT -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<!-- ########## HIDDEN ########## -->
<div class="blackout popup" id="blackout">
</div>
<div class="login popup" id="login">
	<form action="<%=url %><%=EnumActions.Login.toString() %>" method="post">
		<table class="login">
			<tr>
				<td>
					Username :
				</td>
				<td>
					<input type="text" name="user">
				</td>
			</tr>
			<tr>
				<td>
					Password :
				</td>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit">
				</td>
			</tr>
		</table>
	</form>
</div>
<div class="container">
	<!-- ########## HEAD ########## -->
	<div class="header">
		<div class="navigation">
			<div>Accueil</div>
			<%	if(session.getAttribute("membreInfo") != null){
				%><div onClick="document.location= '<%=url %><%=EnumActions.Logout.toString() %>'">D�connecter</div>
			<%}else{
				%><div onClick="showPopup('login')">Login</div>
				
			<%}
			
			%>
		</div>
		<img src="images/logo.gif">
	</div>
	<!-- ########## BODY ########## -->
	<div class="body">
		<div class="leftSidebar">
			<div class="module">
				<div>
					Categorie
				</div>
			
				<div>
				<h5>Choisir une cat�gorie d'aliment</h5>
				<%for(Categorie c: alC){ %><span class="ajax" onClick="requestContent('<%=url %><%=EnumActions.AjaxCategorie.toString() %>&catId=<%=c.getNoCategorie() %>')"><%=c.getDescriptionCategorie() %></span><br/><%} %>
				</div>
			</div>
			<div class="module">
				<div>
					�v�nements
				</div>
				<div>
					<a href="#">Journ�e Bl� D'inde</a><br>
					<a href="#">�tes-vous un bon cuistot?</a><br>
					<a href="#">Lache pas la Patate!</a><br>
					<a href="#">Charit� alimentaire</a>
				</div>
			</div>
			<div class="module">
				<div>
					Recette
				</div>
				<div>
					<a href="http://www.metro.ca/recettes/45/boeuf.fr.html">Boeuf</a><br>
					<a href="http://www.metro.ca/recettes/47/porc.fr.html">Porc</a><br>
					<a href="http://www.metro.ca/recettes/47/poulet.fr.html">Volaile</a><br>
					<a href="http://www.metro.ca/recettes/4/desserts.fr.html">Dessert</a>
				</div>
			</div>
		</div>
		<div class="content" id="content">
			<div>
				<%=titre %>
			</div>
			<div class="error">
				<%=message %>
			</div>
		</div>
		<div class="rightSidebar">
			<div class="module">
				<div>
					Votre Panier
				</div>
				<div>
					0 produit<br>
					<a href="">Voir votre panier</a>
				</div>
			</div>
			-->
		</div>
	</div>
	<div class="clear"></div>
	<!-- ########## FOOTER ########## -->
	<div class="footer clear">
		Conception by: PlucProgramming inc. All rights reserved 2011 IGA inc
	</div>
</div>
</body>
</html>