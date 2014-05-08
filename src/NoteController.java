import java.util.ArrayList;
import javax.faces.event.ActionEvent;

public class NoteController {
	private Note note;
	private ArrayList<Note> notes;

	public void setNotes(ArrayList<Note> notes){
		this.notes = notes;
	}

	public ArrayList<Note> getNotes(){
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
		this.getNotes().add(this.getNote());
		this.setNote(new Note());
	}
}
