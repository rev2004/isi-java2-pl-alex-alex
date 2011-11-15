<%
String nomContext = application.getServletContextName();
String urlControleur = application.getInitParameter("urlController");
String paramAction = application.getInitParameter("paramAction");

String url= "/"+nomContext+"/"+urlControleur+"?"+paramAction+"=";
%>
