function requestContent(path){
	//objet xmlhttprequest
	xmlHttp = null;
	if(window.XMLHttpRequest){ //ff et chrome
		xmlHttp = new XMLHttpRequest();
	} else if(window.ActiveXObject) { //ie
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		alert("Ajax n'est pas supporté par votre navigateur.");
	}
	xmlHttp.onreadystatechange = receiveContent;
	xmlHttp.open("GET", path, true);
	xmlHttp.send(null);
}
function receiveContent(){
	if(xmlHttp.readyState== 4){
		$("#content > div + div").html(xmlHttp.responseText);
	}
}