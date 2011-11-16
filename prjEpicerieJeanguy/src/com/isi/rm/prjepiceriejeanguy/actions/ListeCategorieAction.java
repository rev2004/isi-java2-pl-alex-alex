package com.isi.rm.prjepiceriejeanguy.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.rm.prjepiceriejeanguy.entites.Categorie;
import com.isi.rm.prjepiceriejeanguy.entites.Produits;
import com.isi.rm.prjepiceriejeanguy.managers.CategorieManager;
import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;


public class ListeCategorieAction extends Action {

	public ListeCategorieAction(ConnecteurBD cbd, String destOk,String destBad) {
		super(cbd, destOk, destBad);
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
		System.out.println("GOGO");
		/*
		//Produits
		ProduitManager pm = new CategorieManager(cbd);
		ArrayList<Produits> alP = pm.getAllProduits();
		request.setAttribute("lstProduits", alP);
		*/
	}
		
}

