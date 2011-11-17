package com.isi.prjejg.actions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isi.prjejg.entites.Client;
import com.isi.prjejg.managers.ClientManager;
import com.isi.prjejg.services.ConnecteurBD;

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
		Client login = mm.getLoginMembre(user, password);
		
		if(login != null) {
			
			HttpSession session = request.getSession(true);
			
			//Cookies
			Cookie profileCookie = new Cookie("User_Cookie", user);
			profileCookie.setMaxAge(365*24*60*60);
			response.addCookie(profileCookie);
			
			session.setAttribute("membreInfo", login);
			destination = destOk;
		} else {
			request.setAttribute("message", "Le mot de passe ou le courriel n'est pas valide.");
		}
	}



}
