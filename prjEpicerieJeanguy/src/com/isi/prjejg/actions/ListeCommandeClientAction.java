package com.isi.prjejg.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.entites.Categorie;
import com.isi.prjejg.entites.Client;
import com.isi.prjejg.entites.CommandeClient;
import com.isi.prjejg.entites.Produit;
import com.isi.prjejg.managers.CategorieManager;
import com.isi.prjejg.managers.CommandesClientsManager;
import com.isi.prjejg.services.ConnecteurBD;

public class ListeCommandeClientAction extends Action{

	public ListeCommandeClientAction(ConnecteurBD cbd, String destOk, String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
	}

	@Override
	public void doTheJob(HttpServletRequest request, HttpServletResponse response) {
		super.doTheJob(request, response);
		//Is logged in?
		if((Client)request.getSession().getAttribute("membreInfo") == null)
			return;
		int clientId = ((Client)request.getSession().getAttribute("membreInfo")).getNoClient();
		
		CommandesClientsManager cc = new CommandesClientsManager(cbd);
		ArrayList<CommandeClient> alC = cc.getAllCommandeClientsbyClientID(clientId);
		request.setAttribute("lstCom", alC);
		destination = destOk;
	}
}
