<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../code_utile/dataInit.jsp" %>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/prjP33Final/css/style.css" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%for(Produit p: alP) { %>
<div class="produit">
	<img src="../images/logo.gif">
	<div><%=p.getDescriptionProduit() %></div>
	<div><%=p.getNoCategorie() %></div>
	<div>9.99 $</div>
	<div><a href="#">Acheter</a></div>
</div>
<%} %>
</body>
</html>