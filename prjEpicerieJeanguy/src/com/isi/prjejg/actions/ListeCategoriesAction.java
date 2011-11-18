package com.isi.prjejg.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.entites.Categorie;
import com.isi.prjejg.entites.Client;
import com.isi.prjejg.managers.CategorieManager;
import com.isi.prjejg.services.ConnecteurBD;

public class ListeCategoriesAction extends Action {

	public ListeCategoriesAction(ConnecteurBD cbd, String destOk,String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doTheJob(HttpServletRequest request, HttpServletResponse response) {
		super.doTheJob(request, response);

		CategorieManager cm = new CategorieManager(cbd);
		ArrayList<Categorie> alC = cm.getAllCategories();
		request.setAttribute("lstCat", alC);
	}
}

