<%@include file="../code_utile/dataInit.jsp" %>
<div>
	Votre Panier
</div>
<div>
	<%if(session.getAttribute("membreInfo") != null) { %>
	<div class="right"><%=alCP.size() %> produit<%=(alCP.size()>1?"s":"") %></div>
	<span class="ajax" onClick="requestContent('<%=url %><%=EnumActions.AjaxCartList.toString() %>')">Voir votre panier</span>
	<% } else { %>
	<div class="center">Veuillez vous connecter pour voir cotre pannier.</div>
	<% } %>
</div>