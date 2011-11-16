
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
		alert("ajax non supporté");
	}
	
	//configurer l'objet xmlHttp
	//callback
	xmlHttp.onreadystatechange = recevoirListeFavoris;
	//préparer la requete
	xmlHttp.open("GET", path, true);
	//lancer la requete
	xmlHttp.send(null);

}


//fonction qui traite la réponse le callback
function recevoirListeFavoris(){
	//alert(xmlHttp.readyState);
	//attendre la réponse complète
	if(xmlHttp.readyState== 4){
		//récupérer la réponse
		rep = xmlHttp.responseText;
		//cracher la réponse dans un div
		$("#content > div + div").html(rep);
	}
	
}