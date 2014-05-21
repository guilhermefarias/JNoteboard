package br.com.jnoteboard.controller;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class UserController {
	private String email;
	private String password;
	private boolean loggedIn;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
	  	return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public boolean isLoggedIn() {
	  	return this.loggedIn;
	}

	public void doLogin() throws IOException{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		if (!this.email.isEmpty() && !this.password.isEmpty()){
			this.loggedIn = true;
			HttpSession httpSession = (HttpSession) externalContext.getSession(true);
			httpSession.setAttribute("userController", this);
			externalContext.redirect("/JNoteboard/faces/home.xhtml");
		} else {
			externalContext.redirect("/JNoteboard/faces/login.xhtml");
		}
	}

	public void doLogout() throws IOException{
		this.loggedIn = false;
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession httpSession = (HttpSession) externalContext.getSession(true);
		httpSession.removeAttribute("userController");
		externalContext.redirect("/JNoteboard/faces/login.xhtml");
	}

	public UserController(){
	}
}
