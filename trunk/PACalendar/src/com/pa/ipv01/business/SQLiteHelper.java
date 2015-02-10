package com.pa.ipv01.business;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pa.ipv01.object.objNote;
import com.pa.ipv01.resource.Noteres;

public class SQLiteHelper {

	private Cursor c;
	private SQLiteDatabase db;
	Activity activity;

	public SQLiteHelper(Activity activity) {
		super();
		// TODO Auto-generated constructor stub
		this.activity = activity;

		db = activity.openOrCreateDatabase("Note", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS onenote(title VARCHAR,content VARCHAR,date VARCHAR,time VARCHAR);");

	}

	public void insert(String title, String content, String date, String time) {
		if (title.toString().trim().length() == 0
				|| content.toString().trim().length() == 0
				|| date.toString().trim().length() == 0
				|| time.toString().trim().length() == 0) {
			showMessage("Lỗi", "Không được bỏ trống");
			return;
		} else {
			db.execSQL("INSERT INTO onenote VALUES('" + title + "','" + content
					+ "','" + date + "','" + time + "');");
			activity.finish();
		}
	}

	public void delete(String title) {
		c = db.rawQuery("SELECT * FROM onenote WHERE title='" + title + "'",
				null);
		if (c.moveToFirst()) {
			db.execSQL("DELETE FROM onenote WHERE title='" + title + "'");
		}
	}

	public ArrayList<objNote> showall(ArrayList<objNote> note) {
		note = new ArrayList<objNote>();
		c = db.rawQuery("SELECT * FROM onenote", null);
		if (c.getCount() == 0) {
			// showMessage("Error", "No Note");
		} else {
			while (c.moveToNext()) {
				note.add(new objNote(c.getString(0), c.getString(1), c
						.getString(2), c.getString(3)));
			}
		}
		return note;
	}

	public boolean daynotes(ArrayList<objNote> note, String today) {
		boolean is = false;
		note = new ArrayList<objNote>();
		c = db.rawQuery("SELECT * FROM onenote", null);
		while (c.moveToNext()) {
			if (c.getString(2).equals(today)) {
				is = true;
			}
		}
		return is;
	}

	public void aNotes(ArrayList<objNote> note, String today) {
		note = new ArrayList<objNote>();
		c = db.rawQuery("SELECT * FROM onenote", null);
		StringBuffer buffer = new StringBuffer();
		while (c.moveToNext()) {
			if (c.getString(2).equals(today)) {
				buffer.append(Noteres.title + c.getString(0) + "\n");
				buffer.append(Noteres.content + c.getString(1) + "\n");
				buffer.append(Noteres.date + c.getString(2) + "\n");
				buffer.append(Noteres.time + c.getString(3) + "\n\n");
			}
		}
		showMessage("Ghi chú", buffer.toString());
	}

	public void destroy() {
		db.close();
	}

	public void showMessage(String title, String message) {
		Builder builder = new Builder(activity);
		builder.setCancelable(true);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.show();
	}

}
