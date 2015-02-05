package com.pa.ipv01.object;

public class objNote {
	private String title;
	private String content;
	private String date;
	private String time;

	public objNote(String title, String content, String date, String time) {
		super();
		// TODO Auto-generated constructor stub
		this.title = title;
		this.content = content;
		this.date = date;
		this.time = time;
	}

	public objNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
