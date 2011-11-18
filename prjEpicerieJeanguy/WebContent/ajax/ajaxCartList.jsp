<%@include file="../code_utile/dataInit.jsp" %>
<%for(CartProduit cp: alCP) { %>
<div class="produit">
	<img src="../images/logo.gif">
	<div><b><%=cp.getP().getDescriptionProduit() %></b></div>
	<div><%=cp.getP().getC().getDescriptionCategorie() %></div>
	<div>
		<span class="ajax" onClick="requestContentPanier('<%=url%><%=EnumActions.AddPanier.toString()%>&prodId=<%=cp.getNoProduit()%>');$(this).next().next().html(parseInt($(this).next().next().html())+1)"><b>+</b></span>
		/
		<span class="ajax" onClick="requestContentPanier('<%=url%><%=EnumActions.EnleverUnPanier.toString()%>&prodId=<%=cp.getNoProduit()%>');if(parseInt($(this).next().next().html())==1){$(this).parent().parent().fadeOut('slow');}else{$(this).next().next().html(parseInt($(this).next().next().html())-1);}"><b>-</b></span>
		<span><%=cp.getQteProduitCommande() %></span>x<%=cp.getP().getPrixVendu() %> $
	</div>
	<div><span class="ajax" onclick="requestContentPanier('<%=url%><%=EnumActions.EnleverPanier.toString()%>&prodId=<%=cp.getNoProduit()%>');$(this).parent().parent().fadeOut('slow')">Enlever</span></div>
</div>
<%} %>
<div class="clear"></div>