package com.isi.prjejg.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.entites.Client;
import com.isi.prjejg.managers.CartProduitManager;
import com.isi.prjejg.services.ConnecteurBD;

public class RemoveUnCartProduitAction extends Action {

	public RemoveUnCartProduitAction(ConnecteurBD cbd, String destOk, String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
	}
	
	@Override
	public void doTheJob(HttpServletRequest request, HttpServletResponse response) {
		super.doTheJob(request, response);
		
		CartProduitManager cpm = new CartProduitManager(cbd);
		int clientId = ((Client)request.getSession().getAttribute("membreInfo")).getNoClient();
		int produitId = Integer.parseInt((String)request.getParameter("prodId"));
		cpm.removeUnCartProduit(clientId, produitId);

		new ListeCartProduitAction(cbd, "", "", false).doTheJob(request, response);
		
		destination = destOk;
	}
}
