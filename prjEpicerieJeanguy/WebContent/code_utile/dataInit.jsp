<%@page import="com.isi.prjejg.entites.*" %>
<%@page import="com.isi.prjejg.enums.EnumActions" %>
<%@page import="java.util.*" %>
<%
String nomContext = application.getServletContextName();
String urlControleur = application.getInitParameter("urlController");
String paramAction = application.getInitParameter("paramAction");
String message = (request.getAttribute("message")==null?"":(String)request.getAttribute("message"));

String url= "/"+nomContext+"/"+urlControleur+"?"+paramAction+"=";

ArrayList<Categorie> alC = (ArrayList<Categorie>)request.getAttribute("lstCat");
String titre = "Index";
%>
