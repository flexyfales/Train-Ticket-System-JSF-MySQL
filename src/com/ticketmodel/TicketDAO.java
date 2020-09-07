package com.ticketmodel;

import java.sql.Connection;
import java.sql.DriverManager;



public class TicketDAO {

	
	


		 public static void main(String[] args) {
			TicketDAO objcon= new TicketDAO();
			System.out.println(objcon.get_Connection());
		}
		
		
		
		public Connection get_Connection() {
			Connection conn=null;
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost/ticket","root","");
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			
			
			return conn;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
