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

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<!-- ########## HIDDEN ########## -->
<div class="blackout popup" id="blackout">
</div>
<div class="login popup" id="login">
	<form>
		<table class="login">
			<tr>
				<td>
					Username :
				</td>
				<td>
					<input type="text">
				</td>
			</tr>
			<tr>
				<td>
					Password :
				</td>
				<td>
					<input type="password">
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
			<div onClick="showPopup('login')">Login</div>
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
		<%for(Categorie c: alC){ %>
		<a href="<%=url %><%=ListeCategorieAction.class.getName()%>&catId=<%=c.getNoCategorie() %>"><%=c.getDescriptionCategorie() %></a><br/>

					<%} %>
				</div>
			</div>
			<div class="module">
				<div>
					Module Title
				</div>
				<div>
					Module content<br>
					Module content<br>
					Module content<br>
					Module content
				</div>
			</div>
			<div class="module">
				<div>
					Module Title
				</div>
				<div>
					Module content<br>
					Module content<br>
					Module content<br>
					Module content
				</div>
			</div>
		</div>
		<div class="content">
			<div>
				mid
			</div>
			<div>
				mid
			</div>
		</div>
		<div class="rightSidebar">
			<div class="module">
				<div>
					Module Title
				</div>
				<div>
					Module content<br>
					Module content<br>
					Module content<br>
					Module content
				</div>
			</div>
			<div class="module">
				<div>
					Module Title
				</div>
				<div>
					Module content<br>
					Module content<br>
					Module content<br>
					Module content
				</div>
			</div>
			<div class="module">
				<div>
					Module Title
				</div>
				<div>
					Module content<br>
					Module content<br>
					Module content<br>
					Module content
				</div>
			</div>
			<div class="module">
				<div>
					Module Title
				</div>
				<div>
					Module content<br>
					Module content<br>
					Module content<br>
					Module content
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