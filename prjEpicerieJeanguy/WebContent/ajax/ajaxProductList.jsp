<%@include file="../code_utile/dataInit.jsp" %>
<%for(Produit p: alP) { %>
<div class="produit">
	<img src="../images/logo.gif">
	<div><%=p.getDescriptionProduit() %></div>
	<div><%=p.getNoCategorie() %></div>
	<div>9.99 $</div>
	<div><a href="#">Acheter</a></div>
</div>
<%} %>