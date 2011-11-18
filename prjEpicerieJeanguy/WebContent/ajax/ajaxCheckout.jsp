<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../code_utile/dataInit.jsp" %>
<form action="<%=url %><%=EnumActions.CommitCart.toString() %>" method="post">
<table class="facture" cellspacing="0" cellpadding="0" width="560px">
	<tr>
		<td style="border-bottom:solid 1px black;border-right:solid 1px black"><b>Produit</b></td>
		<td width="100px" style="border-bottom:solid 1px black;border-right:solid 1px black"><b>Quantité</b></td>
		<td width="100px" style="border-bottom:solid 1px black;border-right:solid 1px black"><b>Prix Unitaire</b></td>
		<td width="100px" style="border-bottom:solid 1px black"><b>Prix</b></td></tr>
<% double prixtot=0; %>
<%for(CartProduit cp: alCP) { %>
	<tr>
		<td style="border-right:solid 1px black"><%=cp.getP().getDescriptionProduit() %></td>
		<td style="border-right:solid 1px black"><%=cp.getQteProduitCommande() %></td>
		<td style="border-right:solid 1px black"><%=cp.getP().getPrixVendu() %></td>
		<td><%=(cp.getQteProduitCommande()*cp.getP().getPrixVendu()) %></td>
	</tr>
<%
prixtot = prixtot + (cp.getQteProduitCommande()*cp.getP().getPrixVendu());
}
%>
<tr><td colspan="2" style="border-top:solid 1px black"></td><td style="border-top:solid 1px black"><b>Sous total:</b></td><td style="border-top:solid 1px black"><%=prixtot %></td></tr>
<tr><td></td><td></td><td><b>Taxes:</b></td><td><%=prixtot*0.15 %> $</td></tr>
<tr><td></td><td></td><td><b>Total:</b></td><td><%=prixtot+prixtot*0.15 %> $</td></tr>
</table>
<div style="text-align:right"><input type="submit" value="Confirmer"></div>
</form>