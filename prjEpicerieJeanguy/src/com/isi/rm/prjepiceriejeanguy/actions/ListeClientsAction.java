package com.isi.rm.prjepiceriejeanguy.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.rm.prjepiceriejeanguy.entites.Clients;
import com.isi.rm.prjepiceriejeanguy.managers.ClientManager;
import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;


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
		
		ArrayList<Clients> alC = cm.getAllClients();
		
		request.setAttribute("lstCat", alC);
		
	}

}
