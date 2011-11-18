package com.isi.prjejg.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.entites.CartProduit;
import com.isi.prjejg.entites.Client;
import com.isi.prjejg.managers.CartProduitManager;
import com.isi.prjejg.managers.CommandesClientsManager;
import com.isi.prjejg.managers.ProduitCommandesManager;
import com.isi.prjejg.services.ConnecteurBD;

public class ConfirmCartAction extends Action {

	public ConfirmCartAction(ConnecteurBD cbd, String destOk, String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
	}
	
	@Override
	public void doTheJob(HttpServletRequest request, HttpServletResponse response) {
		super.doTheJob(request, response);
		
		int clientId = ((Client)request.getSession().getAttribute("membreInfo")).getNoClient();
		
		CartProduitManager cpm = new CartProduitManager(cbd);
		ProduitCommandesManager pcm = new ProduitCommandesManager(cbd);
		CommandesClientsManager ccm = new CommandesClientsManager(cbd);
		
		ArrayList<CartProduit> alCP = cpm.getAlCartProduitsByClient(clientId);
		
		//On va chercher le prix total a mettre dans la commande finale
		double totalPrix = 0; 
		for(CartProduit cp: alCP) {
			totalPrix = totalPrix+cp.getP().getPrixVendu();
		}
		
		//On crée la commande et garde le ID
		int commandeId = ccm.addCommandeClient(clientId, totalPrix);
		
		//On ajoute tout les produit
		for(CartProduit cp: alCP) {
			pcm.addCartToCommande(cp, commandeId);
		}
		
		//On vide le cart
		cpm.emptyCartProduit(clientId);
		
		//Refresh le cart
		new GenerateIndexAction(cbd, "", "", false).doTheJob(request, response);
		
		request.setAttribute("message", "Merci d'avoir magasiné chez IGA!.");
		request.setAttribute("message_type", "good");
		
		destination = destOk;
	}
}