package br.com.jnoteboard.controller;

import br.com.jnoteboard.entity.User;

public class UserController {
	private String email;
	private String password;
	private User userLogged;
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

	public String doLogin(){
		return "";
	}

	public String doLogout(){
		return "";
	}

	public UserController(){
	}
}
