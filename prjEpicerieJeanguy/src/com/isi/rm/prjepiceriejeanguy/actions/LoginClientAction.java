package com.isi.rm.prjepiceriejeanguy.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isi.rm.prjepiceriejeanguy.entites.Clients;
import com.isi.rm.prjepiceriejeanguy.managers.ClientManager;
import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;

public class LoginClientAction  extends Action {
	public LoginClientAction(ConnecteurBD cbd, String destOk, String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
		// TODO Auto-generated constructor stub
	}
	



	@Override
	public void doTheJob(HttpServletRequest request, HttpServletResponse response) {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		ClientManager mm = new ClientManager(cbd);
		Clients login = mm.getLoginMembre(user, password);
		System.out.println("FUCK YOU");
		if(login != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("membreInfo", login);
			destination = destOk;
		} else {
			request.setAttribute("message", "Le mot de passe ou le courriel n'est pas valide.");
		}
	}
}
