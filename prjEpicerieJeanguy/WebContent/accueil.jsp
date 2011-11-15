<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
H1
{
    COLOR: orange;
    FONT-FAMILY: 'Times New Roman';
    TEXT-TRANSFORM: capitalize;
    border:solid blue 2px;
    background-color: blue;
    text-align: center;
    
}
#div1
{
	border:solid white 2px;
	color:blue;
	background-color: black;
	font-size: medium;
	font-family: serif;
	text-align:center;
}	

</style>
<%@include file="utile/dataInit.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@page import="com.isi.rm.prjepiceriejeanguy.entites.*" %>
</head>
<body>
<h1>Bienvenue dans notre épicerie!</h1>
<div id="div1">
<p>Bon ben c'est toujours intéressant</p>
<a href="#">Liens pour les produits</a><br/>
<a href="#">Contactez-nous</a>

</div>
</body>
</html>