package com.ticketmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;









@ManagedBean
@SessionScoped


public class Fares {
	public int id;	
public String depart;
public String destination;
public double price;
public double child;




public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDepart() {
	return depart;
}
public void setDepart(String depart) {
	this.depart = depart;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getChild() {
	return child;
}
public void setChild(double child) {
	this.child = child;
}


public void add_Fare() {
	
	try {
		
		Connection conn=null;
		TicketDAO objcon= new TicketDAO();
		conn= objcon.get_Connection();
		PreparedStatement pst=conn.prepareStatement("insert into fares(depart,destination,price,child) values(?,?,?,?)");
		
		pst.setString(1,depart);
    	pst.setString(2,destination);
    	pst.setDouble(3,price);
    	pst.setDouble(4,child);
    	
		pst.executeUpdate();
	}catch(Exception e) {
		System.out.println(e);
	}
	
	
	
}

public List<Fares> findAll(){
	ArrayList <Fares> fareList = new ArrayList <Fares>();
	try {
		
		Connection conn=null;
		TicketDAO objcon= new TicketDAO();
		conn=objcon.get_Connection();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from fares");
		while(rs.next()) {
			Fares obj=new Fares();
			obj.setId(rs.getInt("id"));
			
			obj.setDepart(rs.getString("depart"));
			obj.setDestination(rs.getString("destination"));
			obj.setPrice(rs.getDouble("price"));
			obj.setChild(rs.getDouble("child"));
			
			fareList.add(obj);
		}
	}catch(Exception e) {
		System.out.println(e);
	}
	return fareList;
}
@ManagedProperty(value="#{editTicket}")
private EditTicket editTicket;

public EditTicket getEditTicket() {
	return editTicket;
}
public void setEditTicket(EditTicket editTicket) {
	this.editTicket = editTicket;
}
public void delete(Fares fare) {
	
	try {
		
		Connection conn=null;
		TicketDAO objcon= new TicketDAO();
		conn=objcon.get_Connection();
		PreparedStatement pst=conn.prepareStatement("delete from fares where id =?");
		pst.setInt(1,fare.getId());
		pst.executeUpdate();
	}catch(Exception e) {
		System.out.println(e);
	}
}

public String edit(Fares fare) {
	editTicket.setFares(fare);
	
	return"update-fare";
}


}
