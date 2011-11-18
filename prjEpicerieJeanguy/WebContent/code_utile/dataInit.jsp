<%@page import="com.isi.prjejg.entites.*" %>
<%@page import="com.isi.prjejg.enums.EnumActions" %>
<%@page import="java.util.*" %>
<%
String nomContext = application.getServletContextName();
String urlControleur = application.getInitParameter("urlController");
String paramAction = application.getInitParameter("paramAction");
String message = (request.getAttribute("message")==null?"":(String)request.getAttribute("message"));
String message_type = (request.getAttribute("message_type")==null?"":(String)request.getAttribute("message_type"));

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

ArrayList<CommandeClient> alCom = new ArrayList<CommandeClient>();
int nbCommandes = 0;
if(request.getAttribute("lstCom") != null){
	alCom = (ArrayList<CommandeClient>)request.getAttribute("lstCom");
	for(CommandeClient cc:alCom)
		nbCommandes++;
}

double cartTotal = 0;
for(CartProduit cp: alCP)
	cartTotal = cartTotal + cp.getP().getPrixVendu();

String titre = "Index";

String profileCookie = "";
Cookie[] cookies = request.getCookies();
if(cookies!=null){
	for (int i=0; i<cookies.length; i++) {
	String nomCookie = cookies[i].getName();
		if (nomCookie.equals("profileCookie")) {
			profileCookie = cookies[i].getValue();
		}
	}
}
%>
