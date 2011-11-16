package com.isi.rm.prjepiceriejeanguy.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;

public class Action {
	
	protected ConnecteurBD cbd;
	protected String destOk;
	protected String destBad;
	protected String destination;
	
	
	
	public Action(ConnecteurBD cbd, String destOk, String destBad) {
		super();
		this.cbd = cbd;
		this.destOk = destOk;
		this.destBad = destBad;
		
	}


	public void doTheJob(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	public String getDestination(){
		return destination;
	}
	
}
