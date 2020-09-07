package com.ticketmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;











@ManagedBean(name="ticket")
@SessionScoped
public class Ticket {

public String tclass;
public String tickettype;

private String route;

private String from;
private String to;
private String time;
private String date;
private String ticketno;
private String person;
private double price;
double total;
double subtotal;

public double getPrice() {
	
	return price;
}
public void setPrice(double price) {
	this.price=price;
	  
	
	
	}
	  	
	



public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public double getSubtotal() {
	
	
	
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
public String getTclass() {
	return tclass;
}
public void setTclass(String tclass) {
	this.tclass = tclass;
}
public String getTickettype() {
	return tickettype;
}
public void setTickettype(String tickettype) {
	this.tickettype = tickettype;
}

@ManagedProperty(value="#{fares}")
private Fares fares;

public Fares getFares() {
	return fares;
}
public void setFares(Fares fares) {
	this.fares = fares;
}
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
	
}
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
	
}
public String getTime() {
	Calendar timer=Calendar.getInstance();
	timer.getTime();
	SimpleDateFormat tTime=new SimpleDateFormat("Hh:mm:ss");
	time=tTime.format(timer.getTime());
	return time;
}
public String getDate() {
	Calendar timer=Calendar.getInstance();
	timer.getTime();
	SimpleDateFormat Tdate=new SimpleDateFormat("dd-MMM-yyyy");
	date= Tdate.format(timer.getTime());
	return date;
}
public String getTicketno() {
	int num1;
	String ticketno ="";
	num1=1325 + (int)(Math.random()*4238);
	ticketno += num1+1325;
	return ticketno;
}
public String getRoute() {
	route="ANY";
	return route;
}
@ManagedProperty("#{customer}") 
Customer customer;
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public String getPerson() {
	return person;
}
public void setPerson(String person) {
	this.person=person ;
	//person=customer.getPerson();
}

public void showPrice() {
	try {
		Connection conn=null;
		TicketDAO objcon= new TicketDAO();
		conn=objcon.get_Connection();
		PreparedStatement pst;
		ResultSet rs;
		String add;
		if(from.equals("Harare") && to.equals("Bulawayo")) {
		
		pst=conn.prepareStatement("select price from fares where depart='Harare'and destination = 'Bulawayo' ");
		rs=pst.executeQuery();
		rs.next();
		fares.setPrice(rs.getDouble("price"));
		
	price=fares.getPrice();
	if(tclass.equals("FirstClass")) 
	    price=price*2;
	    if(tclass.equals("Standard")) 
	        price=price+(price*0.5);
		}
	 if(from.equals("Harare") && to.equals("Bulawayo") && person.equals("Child")) {
			
			pst=conn.prepareStatement("select child from fares where depart='Harare'and destination = 'Bulawayo' ");
			rs=pst.executeQuery();
			rs.next();
			fares.setChild(rs.getDouble("child"));
			
		price=fares.getChild();
		if(tclass.equals("FirstClass")) 
		    price=price*2;
		    if(tclass.equals("Standard")) 
		        price=price+(price*0.5);
			}
		if(from.equals("Victoria Falls") && to.equals("Masvingo")) {
			
			pst=conn.prepareStatement("select price from fares where depart='Victoria Falls 'and destination = 'Masvingo' ");
			rs=pst.executeQuery();
			rs.next();
			fares.setPrice(rs.getDouble("price"));
			
		price=fares.getPrice();
		if(tclass.equals("FirstClass")) 
		    price=price*2;
		    if(tclass.equals("Standard")) 
		        price=price+(price*0.5);
			}
		if(from.equals("Victoria Falls") && to.equals("Masvingo") && person.equals("Child")) {
			
			pst=conn.prepareStatement("select child from fares where depart='Victoria Falls'and destination = 'Masvingo' ");
			rs=pst.executeQuery();
			rs.next();
			fares.setChild(rs.getDouble("child"));
			
		price=fares.getChild();
		if(tclass.equals("FirstClass")) 
		    price=price*2;
		    if(tclass.equals("Standard")) 
		        price=price+(price*0.5);
			}
if(from.equals("Johannesburg") && to.equals("Masvingo")) {
			
			pst=conn.prepareStatement("select price from fares where depart='Johannesburg' and destination = 'Masvingo' ");
			rs=pst.executeQuery();
			rs.next();
			fares.setPrice(rs.getDouble("price"));
			
		price=fares.getPrice();
		if(tclass.equals("FirstClass")) 
		    price=price*2;
		    if(tclass.equals("Standard")) 
		        price=price+(price*0.5);
			}
if(from.equals("Johannesburg") && to.equals("Masvingo")&& person.equals("Child")) {
	
	pst=conn.prepareStatement("select child from fares where depart='Johannesburg 'and destination = 'Masvingo' ");
	rs=pst.executeQuery();
	rs.next();
	fares.setChild(rs.getDouble("child"));
	
price=fares.getChild();
if(tclass.equals("FirstClass")) 
    price=price*2;
    if(tclass.equals("Standard")) 
        price=price+(price*0.5);
	}
if(from.equals("Harare") && to.equals("Victoria Falls")) {
	
	pst=conn.prepareStatement("select price from fares where depart='Harare' and destination = 'Victoria Falls' ");
	rs=pst.executeQuery();
	rs.next();
	fares.setPrice(rs.getDouble("price"));
	
price=fares.getPrice();
    if(tclass.equals("FirstClass")) 
    price=price*2;
    if(tclass.equals("Standard")) 
        price=price+(price*0.5);
	}
if(from.equals("Harare") && to.equals("Victoria Falls")&& person.equals("Child")) {

pst=conn.prepareStatement("select child from fares where depart='Harare'and destination = 'Victoria Falls' ");
rs=pst.executeQuery();
rs.next();
fares.setChild(rs.getDouble("child"));

price=fares.getChild();
if(tclass.equals("FirstClass")) 
    price=price*2;
    if(tclass.equals("Standard")) 
        price=price+(price*0.5);


}
if(from.equals("Harare") && to.equals("Johannesburg") ||from.equals("Harare") && to.equals("Harare")||from.equals("Bulawayo") && to.equals("Johannesburg")||from.equals("Johannesburg") && to.equals("Johannesburg")||from.equals("Masvingo") && to.equals("Masvingo")
		||from.equals("Harare") && to.equals("Masvingo")	
		
		
		) {



price= 0;

}
	}
catch(Exception e) {

System.out.println(e);

}
}
	

	






}
