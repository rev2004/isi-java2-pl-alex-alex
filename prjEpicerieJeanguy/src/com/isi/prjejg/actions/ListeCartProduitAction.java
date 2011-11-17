package com.isi.prjejg.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.entites.CartProduit;
import com.isi.prjejg.entites.Client;
import com.isi.prjejg.managers.CartProduitManager;
import com.isi.prjejg.services.ConnecteurBD;

public class ListeCartProduitAction extends Action {

	public ListeCartProduitAction(ConnecteurBD cbd, String destOk, String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doTheJob(HttpServletRequest request, HttpServletResponse response) {
		if((Client)request.getSession().getAttribute("membreInfo") == null)
			return;
		CartProduitManager cpm = new CartProduitManager(cbd);
		int clientId = ((Client)request.getSession().getAttribute("membreInfo")).getNoClient();
		ArrayList<CartProduit> alCP = cpm.getAlCartProduitsByClient(clientId);
		request.setAttribute("lstCart", alCP);
	}
}
