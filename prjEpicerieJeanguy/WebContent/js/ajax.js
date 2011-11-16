
//fonction qui fait le call ajax
function ajouterProspect(path){
	//objet xmlhttprequest
	xmlHttp = null;
	if(window.XMLHttpRequest){ //ff et chrome
		xmlHttp = new XMLHttpRequest();
	}
	else if(window.ActiveXObject){ //ie
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	else{
		alert("ajax non support�");
	}
	
	//configurer l'objet xmlHttp
	//callback
	xmlHttp.onreadystatechange = recevoirListeFavoris;
	//pr�parer la requete
	xmlHttp.open("GET", path, true);
	//lancer la requete
	xmlHttp.send(null);

}


//fonction qui traite la r�ponse le callback
function recevoirListeFavoris(){
	//alert(xmlHttp.readyState);
	//attendre la r�ponse compl�te
	if(xmlHttp.readyState== 4){
		//r�cup�rer la r�ponse
		rep = xmlHttp.responseText;
		//cracher la r�ponse dans un div
		$("#content > div + div").html(rep);
	}
	
}