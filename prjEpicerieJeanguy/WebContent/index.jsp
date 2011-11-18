<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="code_utile/dataInit.jsp"  %>				
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
<div class="enregistrer popup" id="enregistrer">
<form action="<%=url %><%=EnumActions.Enregistrer.toString() %>" method="post">
		<table class="login">
			<tr>			
				<td colspan="2">
				<h1>Enregistrement</h1>
				</td>
			</tr>
			<tr>			
				<td>
					Prénom :
				</td>
				<td>
					<input type="text" name="txprenom">
				</td>
			</tr>
			<tr>			
				<td>
					Nom :
				</td>
				<td>
					<input type="text" name="txnom">
				</td>
			</tr><tr>			
				<td>
					Numéro Civique :
				</td>
				<td>
					<input type="text" name="txnoCivic">
				</td>
			</tr><tr>			
				<td>
					Rue :
				</td>
				<td>
					<input type="text" name="txRue">
				</td>
			</tr><tr>			
				<td>
					Code postal :
				</td>
				<td>
					<input type="text" name="txPostal">
				</td>
			</tr>
			<tr>			
				<td>
					Ville :
				</td>
				<td>
					<input type="text" name="txVille">
				</td>
			</tr>
			<tr>			
				<td>
					Numéro de carte de crédit :
				</td>
				<td>
					<input type="text" name="txnoCredit">
				</td>
			</tr><tr>			
				<td>
					Téléphone :
				</td>
				<td>
					<input type="text" name="txTelephone">
				</td>
			</tr><tr>			
				<td>
					Courriel (username) :
				</td>
				<td>
					<input type="text" name="txCourriel">
				</td>
			</tr><tr>			
				<td>
					Mot de passe :
				</td>
				<td>
					<input type="password" name="txpw">
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
<div class="login popup" id="login">
	<form action="<%=url %><%=EnumActions.Login.toString() %>" method="post">
		<table class="login">
			<tr>
				<td>
					Username :
				</td>
				<td>
					<input type="text" name="user" value="<%=profileCookie%>">
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
				%><div onClick="document.location= '<%=url %><%=EnumActions.Logout.toString() %>'">Déconnecter</div>
			<%}else{
				%>
				<div onClick="showPopup('enregistrer')">Création</div>
				<div onClick="showPopup('login')">Login</div>
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
				<h5>Choisir une catégorie d'aliment</h5>
				<%for(Categorie c: alC){ %><span class="ajax" onClick="requestContent('<%=url %><%=EnumActions.AjaxCategorie.toString() %>&catId=<%=c.getNoCategorie() %>')"><%=c.getDescriptionCategorie() %></span><br/><%} %>
				</div>
			</div>
			<div class="module">
				<div>
					Événements
				</div>
				<div>
					<a href="#">Journée Blé D'inde</a><br>
					<a href="#">Êtes-vous un bon cuistot?</a><br>
					<a href="#">Lache pas la Patate!</a><br>
					<a href="#">Charité alimentaire</a>
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
		<div class="content">
			<div>
				<%=titre %>
			</div>
			<div>
				<div class="<%=message_type %>">
					<%=message %>
					<%message="";message_type=""; %>
				</div>
				<div id="contentAjax"></div>
			</div>
		</div>
		<div class="rightSidebar">
			<div class="module" id="panier">
				<div>
					Votre Panier
				</div>
				<div>
					<%if(session.getAttribute("membreInfo") != null) { %>
					<div style="float:right"><%=cartTotal %></div>
					<div style="float:left"><%=alCP.size() %> produit<%=(alCP.size()>1?"s":"") %></div>
					<div class="clear"></div>
					<div style="float:right"><%=nbCommandes %> commandes</div>
					<div class="clear"></div>
					<span class="ajax" onClick="requestContent('<%=url %><%=EnumActions.AjaxCartList.toString() %>')">Voir votre panier</span><br>
					<span class="ajax" onClick="requestContent('<%=url %><%=EnumActions.AjaxCheckout.toString() %>')">Payer</span>
					<% } else { %>
					<div class="center">Veuillez vous connecter pour voir cotre pannier.</div>
					<% } %>
				</div>
			</div>
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