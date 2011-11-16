package com.isi.rm.prjepiceriejeanguy.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;

public class Action {
	
	protected ConnecteurBD cbd;
	protected String destOk;
	protected String destBad;
	protected String destination;
	protected boolean reqLogin;
	
	
	
	public Action(ConnecteurBD cbd, String destOk, String destBad, boolean reqLogin) {
		super();
		this.cbd = cbd;
		this.destOk = destOk;
		this.destBad = destBad;
		this.destination = destBad;
		this.reqLogin = reqLogin;
	}


	public void doTheJob(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	public String getDestination(){
		return destination;
	}
	public boolean isReqLogin(){
		return reqLogin;
	}
	
}
