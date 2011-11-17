package com.isi.prjejg.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.entites.Produit;
import com.isi.prjejg.managers.ProduitsManager;
import com.isi.prjejg.services.ConnecteurBD;

public class ListeProduitAction extends Action{
	public ListeProduitAction(ConnecteurBD cbd, String destOk, String destBad,
			boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void doTheJob(HttpServletRequest request, HttpServletResponse response) {
		super.doTheJob(request, response);
		ProduitsManager pm = new ProduitsManager();
		String catId = (String)request.getAttribute("catId");
		ArrayList<Produit> alP = pm.getAllProduitsFromCatId(Integer.parseInt(catId));
		request.setAttribute("lstProduit", alP);
		destination = destOk;	
	}
}
