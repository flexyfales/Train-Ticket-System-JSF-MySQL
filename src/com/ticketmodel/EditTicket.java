package com.ticketmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="editTicket")
@SessionScoped
public class EditTicket {
	private Fares fares= new Fares();
	 TicketDAO timb = new TicketDAO();
	public Fares getFares() {
		return fares;
	}
	public void setFares(Fares fares) {
		this.fares = fares;
	}
	public String update() {
		
		
		try {
			Connection conn=null;
			TicketDAO objcon= new TicketDAO();
			conn=objcon.get_Connection();
			PreparedStatement pst=conn.prepareStatement("update fares set depart=?,destination=?,price=?, child=? where id=? ");
			
			
			
			pst.setString(1,fares.getDepart());
			pst.setString(2,fares.getDestination());
			pst.setDouble(3,fares.getPrice());
			pst.setDouble(4,fares.getChild());
			
			pst.setInt(5,fares.getId());
			pst.executeUpdate();
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
		return "fares";
	}


}
