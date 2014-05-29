package br.com.jnoteboard.controller;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.jnoteboard.model.ModelClass;

public class UserController {
	private String name;
	private String login;
	private String email;
	private String password;
	private boolean loggedIn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

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
		ModelClass modelClass = ModelClass.instance();

		if (!this.login.isEmpty() && !this.password.isEmpty()){
			this.loggedIn = true;

			try {
				modelClass.add(this.login);
			} catch (Exception e) {}

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
