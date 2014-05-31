package br.com.jnoteboard.controller;

import java.util.ArrayList;
import javax.faces.event.ActionEvent;
import br.com.jnoteboard.entity.Note;
import br.com.jnoteboard.model.NoteModel;

public class NoteController {
	private Note note;
	private ArrayList<Note> notes;

	public void setNotes(ArrayList<Note> notes){
		this.notes = notes;
	}

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
		this.setNotes(new ArrayList<Note>());
		this.setNote(new Note());
	}

	public void addAction(ActionEvent event){
		NoteModel noteModel = NoteModel.instance();

		try {
			noteModel.insert(this.note);
		} catch (Exception e) {}
	}
}
