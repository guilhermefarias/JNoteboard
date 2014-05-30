package br.com.jnoteboard.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.jnoteboard.entity.User;

import com.mysql.jdbc.PreparedStatement;

public class UserModel {
	private static UserModel userModel;
	public static UserModel instance(){
		if(userModel == null){
			userModel = new UserModel();
		}
		return userModel;
	}

	private UserModel(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver carregado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(User user) throws Exception {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/jnoteboard","root","");
			String selectSQL = "INSERT INTO `user` (login,password,email,name) VALUES (?,?,?,?)";
			st = (PreparedStatement) con.prepareStatement(selectSQL);
			st.setString(1, user.getLogin());
			st.setString(2, user.getPassword());
			st.setString(3, user.getEmail());
			st.setString(4, user.getName());
			st.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (Exception e){}
			try {
				con.close();
			} catch (Exception e){}
		}
	}

}