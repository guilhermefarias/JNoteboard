package br.com.jnoteboard.controller;

import java.util.ArrayList;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import br.com.jnoteboard.entity.Note;
import br.com.jnoteboard.model.NoteModel;

public class NoteController {
	private Note note;

	public ArrayList<Note> getNotes(){
		ArrayList<Note> notes = new ArrayList<Note>();
		NoteModel noteModel = NoteModel.instance();

		try {
			notes = noteModel.list(5);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return notes;
		
	}

	public void setNote(Note note){
		this.note = note;
	}

	public Note getNote(){
		return this.note;
	}

	public NoteController(){
		this.note = new Note();
	}

	public void addAction(){
		NoteModel noteModel = NoteModel.instance();

		try {
			noteModel.insert(this.note);
			this.note = new Note();
		} catch (Exception e) {}
	}

	public void deleteAction(){
		NoteModel noteModel = NoteModel.instance();
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String value = externalContext.getRequestParameterMap().get("id");
		int id = Integer.parseInt(value);

		try {
			noteModel.delete(id);
		} catch (Exception e) {}
	}
}
