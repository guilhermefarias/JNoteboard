package br.com.jnoteboard.controller;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import br.com.jnoteboard.entity.User;
import br.com.jnoteboard.model.UserModel;

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
		boolean userExist = false;
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		UserModel userModel = UserModel.instance();
		User user = new User();
		user.setLogin(this.login);
		user.setPassword(this.password);

		if (!this.login.isEmpty() && !this.password.isEmpty()){
			try {
				userExist = userModel.exist(user);
				System.out.print(userExist);
				this.loggedIn = true;
			} catch (Exception e) {}

			if(userExist){
				HttpSession httpSession = (HttpSession) externalContext.getSession(true);
				httpSession.setAttribute("userController", this);
				externalContext.redirect("/JNoteboard/faces/home.xhtml");
			} else {
				externalContext.redirect("/JNoteboard/faces/login.xhtml");
			}
			
		} else {
			externalContext.redirect("/JNoteboard/faces/login.xhtml");
		}
	}

	public void join() throws IOException{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		UserModel userModel = UserModel.instance();
		User user = new User();
		user.setName(this.name);
		user.setLogin(this.login);
		user.setEmail(this.email);
		user.setPassword(this.password);

		if (!this.name.isEmpty() && !this.login.isEmpty() && !this.email.isEmpty() && !this.password.isEmpty()){
			try {
				userModel.insert(user);
				this.loggedIn = true;
				HttpSession httpSession = (HttpSession) externalContext.getSession(true);
				httpSession.setAttribute("userController", this);
				externalContext.redirect("/JNoteboard/faces/home.xhtml");
			} catch (Exception e) {
				externalContext.redirect("/JNoteboard/faces/join.xhtml");
			}
		} else {
			externalContext.redirect("/JNoteboard/faces/join.xhtml");
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
