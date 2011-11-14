package com.isi.rm.prjepiceriejeanguy.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnecteurBD {
	private Connection conn;
	private String connStr;
	public ConnecteurBD(String driver, String connStr){
		this.connStr = connStr;
		//loader driver
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//établir la connection
		ouvrirConnexion();
		
	}
	
	private void ouvrirConnexion(){
		try {
			conn =  DriverManager.getConnection(connStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getPreparedStatement(String sql){
		//vérifier la connection
		try {
			if(conn.isClosed()){
				ouvrirConnexion();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public void  fermerConnexion(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
