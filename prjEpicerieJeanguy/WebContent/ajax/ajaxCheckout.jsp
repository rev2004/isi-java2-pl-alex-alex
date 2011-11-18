<%@include file="../code_utile/dataInit.jsp" %>
<table><tr><td>Produit</td><td>Quantité</td><td>Prix Unitaire</td><td>Prix</td></tr>
<% double prixtot=0; %>
<%for(CartProduit cp: alCP) { %>
<tr><td><%=cp.getP().getDescriptionProduit() %></td><td><%=cp.getQteProduitCommande() %></td><td><%=cp.getP().getPrixVendu() %></td><td><%=(cp.getQteProduitCommande()*cp.getP().getPrixVendu()) %></td></tr>
<%
prixtot = prixtot + (cp.getQteProduitCommande()*cp.getP().getPrixVendu());
}
%>
<tr><td></td><td></td><td>Sous total:</td><td><%=prixtot %></td></tr>
<tr><td></td><td></td><td>Taxes:</td><td><%=prixtot*0.15 %></td></tr>
<tr><td></td><td></td><td>Total:</td><td><%=prixtot+prixtot*0.15 %></td></tr>
</table>