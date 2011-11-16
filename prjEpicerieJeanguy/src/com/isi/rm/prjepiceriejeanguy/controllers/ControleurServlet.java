package com.isi.rm.prjepiceriejeanguy.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.rm.prjepiceriejeanguy.actions.Action;
import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;

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
		
		// et ainsi de suite pour toutes les actions....
		
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * version sans if else if....
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		//récup job
		String job = request.getParameter(nomParamJob);
		String destView = "/intro.jsp";
		//si pas de job
		
		if(job!=null){
			//récup l'action
			Action a = hActions.get(job);
			//s'assurer qu'on a trouvé une action
			if(a!=null){
				//executer l'action
				a.doTheJob(request, response);
				destView = a.getDestination();
				
			}
		
		}
		
		//forward
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(destView);
		rd.forward(request, response);
		
		
	}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//prendre acte de la job demandée par le view
		System.out.println("le servlet répond");
		String jobDemandee = request.getParameter(nomParamJob);
		String destinationView="/intro.jsp";
		if(jobDemandee==null){
			//faire la job par défaut
			response.sendRedirect("intro.jsp");
			return;			
		}
		//appeler l'action responsable de ce travail
		if(jobDemandee.equals("listeMembre")){
			System.out.println("job= listeMembre");
			ListeCategorieAction lca = new ListeCategorieAction(cbd,"/listeMembres.jsp" );
			lca.listerCategorie(request);
			destinationView = lca.getDestination();
		}
		else if(jobDemandee.equals("inscriptionForm")){
			System.out.println("job= inscriptionForm");
		}
		else if(jobDemandee.equals("membresParCat")){
			ListeMembreAction lma = new ListeMembreAction(cbd, "/listeMembres.jsp");
			lma.obtenirListeMembres(request);
			destinationView = lma.getDestination();
		}
		
		//transférer vers le view de destination
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(destinationView);
		rd.forward(request, response);
		
		
		
				
		
	}
	*/

}
