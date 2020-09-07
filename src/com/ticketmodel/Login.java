package com.ticketmodel;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class Login implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String username;
private final String ADMIN ="admin";
private final String PASS="admin";
private String password;



public void grantPermision(){
	FacesContext facesContext =FacesContext.getCurrentInstance();
	HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(true);
	Object adminLoggedIn=session.getAttribute("admin");
	ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
	if(adminLoggedIn==null) {
		try {
			context.redirect("login.xhtml?faces-redirect=true");
		} catch (IOException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public String validateLogin() {
	if(username.equals(ADMIN)&&password.equals(PASS)) {
		HttpSession session=SessionUtil.getSession();
		session.setAttribute("admin", ADMIN);
		return "Fares?faces-redirect=true";
	}else {
		String message ="Invalid details";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,message,null));
		return "login";
	}
	
	
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getADMIN() {
	return ADMIN;
}
public String getPASS() {
	return PASS;
}


}
