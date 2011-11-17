<%@include file="../code_utile/dataInit.jsp" %>
<%for(Produit p: alP) { %>
<div class="produit">
	<img src="../images/logo.gif">
	<div><b><%=p.getDescriptionProduit() %></b></div>
	<div><%=p.getC().getDescriptionCategorie() %></div>
	<div><%=p.getPrixVendu() %> $</div>
	<div>
	<%
	if(session.getAttribute("membreInfo") == null) {
	%>
		<span class="ajax" onClick="showPopup('login')">Acheter</span>
	<% } else { %>
		<span class="ajax" onClick="requestContentPanier('<%=url%><%=EnumActions.AddPanier.toString()%>&prodId=<%=p.getNoProduit()%>')">Acheter</span>
	<% } %>
	</div>
</div>
<%} %>
<div class="clear"></div>