<%@page import="com.isi.rm.prjepiceriejeanguy.entites.*" %>
<%@page import="com.isi.rm.prjepiceriejeanguy.actions.*" %>
<%@page import="com.isi.rm.prjepiceriejeanguy.managers.*" %>
<%@page import="com.isi.rm.prjepiceriejeanguy.controllers.*" %>
<%@page import="com.isi.rm.prjepiceriejeanguy.services.*" %>
<%@page import="java.util.*" %>
<%
String nomContext = application.getServletContextName();
String urlControleur = application.getInitParameter("urlController");
String paramAction = application.getInitParameter("paramAction");

String url= "/"+nomContext+"/"+urlControleur+"?"+paramAction+"=";

ArrayList<Categorie> alC = (ArrayList<Categorie>)request.getAttribute("lstCat");
%>
