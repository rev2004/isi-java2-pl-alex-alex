package com.isi.prjejg.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isi.prjejg.entites.Client;
import com.isi.prjejg.services.ConnecteurBD;

public class ClientManager {
	private ConnecteurBD cbd;
	
	
	public ClientManager(ConnecteurBD cbd){
		
		this.cbd=cbd;
	}
	
	public ArrayList<Client> getAllClients(){
		ArrayList<Client> alC= new ArrayList<Client>();
		String sql = "select * from Clients";
		PreparedStatement ps=null;
		ResultSet rs=null;
		ps = cbd.getPreparedStatement(sql);
		try {
			rs = ps.executeQuery();
			
			while(rs.next()){

				Client c = new Client (rs.getInt("noClient"),
										rs.getString("nomClient"),
										rs.getString("prenomClient"),
										rs.getInt("NoCiviqueClient"),
										rs.getString("rueClient"),
										rs.getString("codePostalClient"),
										rs.getString("villeClient"),
										rs.getString("noCarteCredit"),
										rs.getString("telephoneClient"),
										rs.getString("courrielClient"),
										rs.getString("passwordClient"));
				alC.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return alC;	
	}
	
	public Client getLoginMembre(String username, String password){
		ArrayList<Client> alMembre = getAlClientsFromQuery("select * from clients where courrielClient='"+username+"' and passwordClient='"+password+"'");
		if(alMembre.size()>0)
			return alMembre.get(0);
		else
			return null;
	}
	
	private ArrayList<Client> getAlClientsFromQuery(String req){
		ArrayList<Client> alC = new ArrayList<Client>(); 
		PreparedStatement ps=null;
		ResultSet rs= null;
		ps= cbd.getPreparedStatement(req);
		
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				Client m = new Client(rs.getInt("noClient"),
						rs.getString("nomClient"),
						rs.getString("prenomClient"),
						rs.getInt("NoCiviqueClient"),
						rs.getString("rueClient"),
						rs.getString("codePostalClient"),
						rs.getString("villeClient"),
						rs.getString("noCarteCredit"),
						rs.getString("telephoneClient"),
						rs.getString("courrielClient"),
						rs.getString("passwordClient"));
				alC.add(m);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				cbd.fermerConnexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return alC;
	}
	
	
	public int enregistrerClient(Client c){
		int id=-1;
	  //Add the data into the database
		PreparedStatement pst;
	String sql = 
	   "insert into clients (nomClient,prenomClient,noCiviqueClient,rueClient,codePostalClient,villeClient,noCarteCredit,telephoneClient,courrielClient,passwordClient) values(?,?,?,?,?,?,?,?,?,?)";
	   pst =  cbd.getPreparedStatement(sql);
		  try {
			  pst.setString(1, c.getNomClient());
			  pst.setString(2, c.getPrenomClient());
			  pst.setInt(3, c.getNoCiviqueClient());
			  pst.setString(4, c.getRueClient());
			  pst.setString(5, c.getCodePostalClient());
			  pst.setString(6, c.getVilleClient());
			  pst.setString(7, c.getNoCarteCredit());
			  pst.setString(8, c.getTelephoneClient());
			  pst.setString(9, c.getCourrielClient());
			  pst.setString(10, c.getPasswordClient());
			  						  
		  //récupérer la string préparé
	  sql= pst.toString();
	  sql= sql.substring(sql.indexOf(":")+2);
	  
	  //executer le insert et récupérer le id (autonumber) généré
	  pst.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
	  ResultSet rs = pst.getGeneratedKeys();
	  rs.next();
	  id = rs.getInt("GENERATED_KEY");
	
	
	  } catch (SQLException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  } finally {
		  try {
			  pst.close();
			  cbd.fermerConnexion();
		  } catch (SQLException e) {
			  // TODO Auto-generated catch block
					  e.printStackTrace();
				  }
			  }
	  return id;
			}
	}
