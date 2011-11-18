<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../code_utile/dataInit.jsp" %>
<div>
	Votre Panier
</div>
<div>
	<%if(session.getAttribute("membreInfo") != null) { %>
	<div style="float:right"><%=cartTotal %> $</div>
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