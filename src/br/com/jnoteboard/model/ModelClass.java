package br.com.jnoteboard.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class ModelClass {
	private static ModelClass modelClass;
	public static ModelClass instance(){
		if(modelClass == null){
			modelClass = new ModelClass();
		}
		return modelClass;
	}

	private ModelClass(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver carregado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(String nome) throws Exception {
		Connection con = null;
		Statement st = null;
		System.out.println("ADD");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/jnoteboard","root","");
			String selectSQL = "INSERT INTO `user` (login,password,email) VALUES (?,?,?)";
			System.out.println("1");	
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(selectSQL);
			System.out.println("2");
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, nome);
			preparedStatement.setString(3, nome);
			System.out.println("3");
			System.out.println("INDO");
			preparedStatement.executeUpdate();
			System.out.println("FOI");
		} catch (SQLException e){
			System.out.println("ERRO");
			e.printStackTrace();
			//throw new Exception("Erro no banco de dados", e);
		} finally {
			System.out.println("FINALY");
			try {
				st.close();
			} catch (Exception e){}
			try {
				con.close();
			} catch (Exception e){}
		}
	}

	public void remover(int id) throws Exception {
		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/jnoteboard?user=root&password=");
			st = con.createStatement();
			String sqlQuery = "DELETE FROM `people` WHERE `id` = "+ id;
			st.executeUpdate(sqlQuery);
		} catch (SQLException e){
			throw new Exception("Erro no banco de dados", e);
		} finally {
			try {
				st.close();
			} catch (Exception e){}
			try {
				con.close();
			} catch (Exception e){}
		}
	}

	public void listar() throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/java?user=root&password=");
			st = con.createStatement();
			String sqlQuery = "SELECT * FROM people";
			rs = st.executeQuery(sqlQuery);

			while(rs.next()){
				int id = rs.getInt(1);
				String nome = rs.getString(2);

				System.out.println(id + " - " + nome);
			}
		} catch (SQLException e){
			throw new Exception("Erro no banco de dados", e);
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