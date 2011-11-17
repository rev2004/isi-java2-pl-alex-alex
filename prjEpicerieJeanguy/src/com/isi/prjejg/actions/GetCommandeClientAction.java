package com.isi.prjejg.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.entites.CommandeClient;
import com.isi.prjejg.entites.Produit;
import com.isi.prjejg.managers.CommandesClientsManager;
import com.isi.prjejg.services.ConnecteurBD;

public class GetCommandeClientAction extends Action{

	public GetCommandeClientAction(ConnecteurBD cbd, String destOk,
			String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
		// TODO Auto-generated constructor stub
		}

	@Override
	public void doTheJob(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		super.doTheJob(request, response);
		CommandesClientsManager cc = new CommandesClientsManager();
		String clientId = (String)request.getAttribute("clientId");
		System.out.println((String)request.getAttribute("clientId"));
		ArrayList<CommandeClient> alCC = cc.getAllCommandeClientsbyClientID(Integer.parseInt(clientId));
		request.setAttribute("lstClientId", alCC);
		destination = destOk;	
		
	
		
	}

}
