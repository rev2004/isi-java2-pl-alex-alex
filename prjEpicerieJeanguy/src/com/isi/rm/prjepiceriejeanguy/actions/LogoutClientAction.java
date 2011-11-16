package com.isi.rm.prjepiceriejeanguy.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;

public class LogoutClientAction extends Action{
	public LogoutClientAction(ConnecteurBD cbd, String destOk, String destBad, boolean reqLogin) {
		super(cbd, destOk, destBad, reqLogin);
	}

	@Override
	public void doTheJob(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.invalidate();
		destination = destOk;
	}

}