package com.isi.rm.prjepiceriejeanguy.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.rm.prjepiceriejeanguy.entites.Categorie;
import com.isi.rm.prjepiceriejeanguy.managers.CategorieManager;
import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;


public class ListeCategorieAction extends Action {

	public ListeCategorieAction(ConnecteurBD cbd, String destOk,String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void doTheJob(HttpServletRequest request,
			HttpServletResponse response) {
		destination = destOk;
		
		//Categorie
		CategorieManager cm = new CategorieManager(cbd);
		ArrayList<Categorie> alC = cm.getAllCategories();
		request.setAttribute("lstCat", alC);

		/*
		//Produits
		ProduitManager pm = new CategorieManager(cbd);
		ArrayList<Produits> alP = pm.getAllProduits();
		request.setAttribute("lstProduits", alP);
		*/
	}
		
}

