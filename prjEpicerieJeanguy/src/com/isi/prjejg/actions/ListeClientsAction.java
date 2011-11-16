package com.isi.prjejg.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.entites.Client;
import com.isi.prjejg.managers.ClientManager;
import com.isi.prjejg.services.ConnecteurBD;


public class ListeClientsAction extends Action {

	public ListeClientsAction(ConnecteurBD cbd, String destOk, String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doTheJob(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		destination = destOk;
		
		ClientManager cm = new ClientManager(cbd);
		
		ArrayList<Client> alC = cm.getAllClients();
		
		request.setAttribute("lstCat", alC);
		
	}

}
