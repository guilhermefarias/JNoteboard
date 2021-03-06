package br.com.jnoteboard.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.jnoteboard.entity.Note;

import com.mysql.jdbc.PreparedStatement;

public class NoteModel {
	private static NoteModel noteModel;
	public static NoteModel instance(){
		if(noteModel == null){
			noteModel = new NoteModel();
		}
		return noteModel;
	}

	private NoteModel(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver carregado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(Note note) throws Exception {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/jnoteboard","root","");
			String selectSQL = "INSERT INTO `note` (user_id, note_text) VALUES (?,?)";
			st = (PreparedStatement) con.prepareStatement(selectSQL);
			st.setInt(1, note.getUserId());
			st.setString(2, note.getText());
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

	public void delete(int id) throws Exception {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/jnoteboard","root","");
			String querySQL = "DELETE FROM `note` WHERE id = ?";
			st = (PreparedStatement) con.prepareStatement(querySQL);
			st.setInt(1, id);
			st.execute();
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

	public ArrayList<Note> list(int userId) throws Exception {
		ArrayList<Note> notes = new ArrayList<Note>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/jnoteboard","root","");
			String selectSQL = "SELECT * FROM `note` WHERE user_id = ?";
			st = (PreparedStatement) con.prepareStatement(selectSQL);
			st.setInt(1, userId);
			rs = st.executeQuery();

			while(rs.next()){
				Note note = new Note();
				note.setId(rs.getInt("id"));
				note.setText(rs.getString("note_text"));
				note.setUserId(rs.getInt("user_id"));
				notes.add(note);
			}
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
		return notes;
	}
}