package br.com.jnoteboard.entity;

public class Note {
	private String text;
	private int userId;

	public void setText(String text){
		this.text = text;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public String getText(){
		return this.text;
	}

	public int getUserId(){
		return this.userId;
	}

	public Note(){
	}
}
