package br.com.jnoteboard.entity;

public class User {
	private String name;
	private String email;
	private String login;	
    private String username;
    private String password;
    
    public void setUsername(String username){
    	this.username = username;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }

    public String getUsername(){
    	return this.username;
    }
    
    public String getPassword(){
    	return this.password;
    }

    public String getLogin(){
    	return this.login;
    }
    
    public void setLogin(String login){
    	this.login = login;
    }
    
    public String getEmail(){
    	return this.email;
    }

    public void setEmail(String email){
    	this.email = email;
    }

    public String getName(){
    	return this.name;
    }
    
    public void setName(String name){
    	this.name = name;
    }

}
