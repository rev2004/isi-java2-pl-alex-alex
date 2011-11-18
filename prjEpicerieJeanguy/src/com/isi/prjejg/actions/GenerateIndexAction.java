package com.isi.prjejg.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.services.ConnecteurBD;


public class GenerateIndexAction extends Action {

	public GenerateIndexAction(ConnecteurBD cbd, String destOk,String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void doTheJob(HttpServletRequest request, HttpServletResponse response) {
		destination = destOk;
		
		new ListeCategoriesAction(cbd, "", "", false).doTheJob(request, response);
		new ListeCartProduitAction(cbd, "", "", false).doTheJob(request, response);
		new ListeCommandeClientAction(cbd, "", "", false).doTheJob(request, response);
		new ListeProduitAction(cbd, "", "", false).doTheJob(request, response);
	}
		
}

