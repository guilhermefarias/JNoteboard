
public class User {
	private String name;
	private String login;
	private String password;

	public void setName(String name){
		this.name = name;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getName(){
		return this.name;
	}

	public String getLogin(){
		return this.login;
	}

	public String getPassword(){
		return this.password;
	}

	public User(){
	}
}
