package com.isi.prjejg.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.actions.Action;
import com.isi.prjejg.actions.AddCartProduitAction;
import com.isi.prjejg.actions.ConfirmCartAction;
import com.isi.prjejg.actions.EnregistrerClientAction;
import com.isi.prjejg.actions.GenerateIndexAction;
import com.isi.prjejg.actions.ListeCartProduitAction;
import com.isi.prjejg.actions.ListeProduitAction;
import com.isi.prjejg.actions.LoginClientAction;
import com.isi.prjejg.actions.LogoutClientAction;
import com.isi.prjejg.actions.RemoveCartProduitAction;
import com.isi.prjejg.actions.RemoveUnCartProduitAction;
import com.isi.prjejg.enums.EnumActions;
import com.isi.prjejg.services.ConnecteurBD;

/**
 * Servlet implementation class ControleurServlet
 */
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String nomParamJob;
	//liste des actions
	private HashMap<String, Action> hActions;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		//r�cup�rer les context param
		String driver = this.getServletContext().getInitParameter("driver");
		String connStr = this.getServletContext().getInitParameter("connStr");
		nomParamJob = this.getServletContext().getInitParameter("paramAction");
		
		//instancier les services
		ConnecteurBD cbd = new ConnecteurBD(driver, connStr);
		
		//instancier la liste  des actions
		hActions = new HashMap<String, Action>();
		
		//On d�clare tout les actions du site
		//Page Compl�te 
		hActions.put(EnumActions.Index.toString(),new GenerateIndexAction(cbd, "/index.jsp", "/erreur.jsp", false));
		hActions.put(EnumActions.Login.toString(),new LoginClientAction(cbd, "/index.jsp", "/index.jsp", false));
		hActions.put(EnumActions.Logout.toString(),new LogoutClientAction(cbd, "/index.jsp", "/index.jsp", true));
		hActions.put(EnumActions.Enregistrer.toString(),new EnregistrerClientAction(cbd, "/index.jsp", "/index.jsp", false));
		//Ajax
		hActions.put(EnumActions.AjaxCategorie.toString(),new GenerateIndexAction(cbd, "/ajax/ajaxProductList.jsp", "/ajax/ajaxError.jsp", false));
		hActions.put(EnumActions.AjaxCartList.toString(),new GenerateIndexAction(cbd, "/ajax/ajaxCartList.jsp", "/ajax/ajaxError.jsp", true));
		hActions.put(EnumActions.AjaxCheckout.toString(),new GenerateIndexAction(cbd, "/ajax/ajaxCheckout.jsp", "/ajax/ajaxError.jsp", true));
		//Module
		hActions.put(EnumActions.ModulePanier.toString(),new GenerateIndexAction(cbd, "/ajax/ajaxModulePanier.jsp", "/ajax/ajaxError.jsp", false));
		//Action
		hActions.put(EnumActions.AddPanier.toString(),new AddCartProduitAction(cbd, "/ajax/ajaxModulePanier.jsp", "/ajax/ajaxError.jsp", true));
		hActions.put(EnumActions.EnleverPanier.toString(),new RemoveCartProduitAction(cbd, "/ajax/ajaxModulePanier.jsp", "/ajax/ajaxError.jsp", true));
		hActions.put(EnumActions.EnleverUnPanier.toString(),new RemoveUnCartProduitAction(cbd, "/ajax/ajaxModulePanier.jsp", "/ajax/ajaxError.jsp", true));
		hActions.put(EnumActions.CommitCart.toString(),new ConfirmCartAction(cbd, "/index.jsp", "/ajax/ajaxError.jsp", true));
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * version sans if else if....
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action a;
		String destView;
		
		//r�cup job
		String job = request.getParameter(nomParamJob);
		
		if(job==null)
			a = hActions.get(EnumActions.Index.toString());
		else
			a = hActions.get(job);
		
		//V�rifier si on a besoin de logger et si on est logg�
		if(a.isReqLogin() == false || request.getSession().getAttribute("membreInfo") != null) {
			a.doTheJob(request, response);
			destView = a.getDestination();
		} else {
			a = hActions.get(EnumActions.Index.toString());
			a.doTheJob(request, response);
			destView = a.getDestination();
		}
		
		if(destView=="/index.jsp")
			hActions.get(EnumActions.Index.toString()).doTheJob(request, response);

		//forward
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(destView);
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	

}
