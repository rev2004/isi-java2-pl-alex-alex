package com.isi.prjejg.actions;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isi.prjejg.entites.Client;
import com.isi.prjejg.managers.ClientManager;
import com.isi.prjejg.services.ConnecteurBD;

public class EnregistrerClientAction extends Action{

	public EnregistrerClientAction(ConnecteurBD cbd, String destOk,
			String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void doTheJob(HttpServletRequest request, HttpServletResponse response) {
		destination = destOk;
		ClientManager cm = new ClientManager(cbd);
		Client c = new Client(
				0,
				(String)request.getParameter("txnom"),
				(String)request.getParameter("txprenom"),
				Integer.parseInt((String)request.getParameter("txnoCivic")),
				(String)request.getParameter("txRue"),
				(String)request.getParameter("txPostal"),
				(String)request.getParameter("txVille"),
				(String)request.getParameter("txnoCredit"),
				(String)request.getParameter("txTelephone"),
				(String)request.getParameter("txCourriel"),
				(String)request.getParameter("txpw")
				);
		
		c.setNoClient(cm.enregistrerClient(c));
		
		request.setAttribute("membreInfo", c);
		
	}
}

