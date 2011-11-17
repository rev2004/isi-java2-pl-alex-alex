<%@page import="com.isi.prjejg.entites.*" %>
<%@page import="com.isi.prjejg.enums.EnumActions" %>
<%@page import="java.util.*" %>
<%
String nomContext = application.getServletContextName();
String urlControleur = application.getInitParameter("urlController");
String paramAction = application.getInitParameter("paramAction");
String message = (request.getAttribute("message")==null?"":(String)request.getAttribute("message"));

String url= "/"+nomContext+"/"+urlControleur+"?"+paramAction+"=";

ArrayList<Produit> alP = new ArrayList<Produit>();
if(request.getAttribute("lstProd") != null)
	alP = (ArrayList<Produit>)request.getAttribute("lstProd");

ArrayList<Categorie> alC = new ArrayList<Categorie>();
if(request.getAttribute("lstCat") != null)
	alC = (ArrayList<Categorie>)request.getAttribute("lstCat");

ArrayList<CartProduit> alCP = new ArrayList<CartProduit>();
if(request.getAttribute("lstCart") != null)
	alCP = (ArrayList<CartProduit>)request.getAttribute("lstCart");

String titre = "Index";
%>
