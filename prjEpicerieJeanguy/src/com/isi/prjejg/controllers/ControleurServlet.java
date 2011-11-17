package com.isi.prjejg.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.prjejg.actions.Action;
import com.isi.prjejg.actions.GenerateIndexAction;
import com.isi.prjejg.actions.ListeProduitAction;
import com.isi.prjejg.actions.LoginClientAction;
import com.isi.prjejg.actions.LogoutClientAction;
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
		//récupérer les context param
		String driver = this.getServletContext().getInitParameter("driver");
		String connStr = this.getServletContext().getInitParameter("connStr");
		nomParamJob = this.getServletContext().getInitParameter("paramAction");
		
		//instancier les services
		ConnecteurBD cbd = new ConnecteurBD(driver, connStr);
		
		//instancier la liste  des actions
		hActions = new HashMap<String, Action>();
		
		//On déclare tout les actions du site
		//Page Complète
		hActions.put(EnumActions.Index.toString(),new GenerateIndexAction(cbd, "/index.jsp", "/erreur.jsp", false));
		hActions.put(EnumActions.Login.toString(),new LoginClientAction(cbd, "/index.jsp", "/index.jsp", false));
		hActions.put(EnumActions.Logout.toString(),new LogoutClientAction(cbd, "/index.jsp", "/index.jsp", true));
		//Ajax
		hActions.put(EnumActions.AjaxCategorie.toString(),new ListeProduitAction(cbd, "/ajax/ajaxProductList.jsp", "/ajax/ajaxError.jsp", false));
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * version sans if else if....
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action a;
		String destView;
		
		//récup job
		String job = request.getParameter(nomParamJob);
		
		if(job==null)
			a = hActions.get(EnumActions.Index.toString());
		else
			a = hActions.get(job);
		
		//Vérifier si on a besoin de logger et si on est loggé
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
