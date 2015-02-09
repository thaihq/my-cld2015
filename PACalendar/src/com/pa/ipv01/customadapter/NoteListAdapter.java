package com.pa.ipv01.customadapter;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pa.ipv01.business.SQLiteHelper;
import com.pa.ipv01.object.objNote;
import com.pa.pacalendar.R;

public class NoteListAdapter extends ArrayAdapter<objNote> {
	Activity context;
	ArrayList<objNote> myArray = null;
	int layoutId;

	public NoteListAdapter(Activity context, int layoutId,
			ArrayList<objNote> myArray) {
		super(context, layoutId, myArray);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.layoutId = layoutId;
		this.myArray = myArray;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			convertView = inflater.inflate(layoutId, parent, false);
			holder = new ViewHolder();

			holder.title = (TextView) convertView
					.findViewById(R.id.itemlist_noteadd_title);
			holder.content = (TextView) convertView
					.findViewById(R.id.itemlist_noteadd_content);
			holder.date = (TextView) convertView
					.findViewById(R.id.itemlist_noteadd_date);
			holder.time = (TextView) convertView
					.findViewById(R.id.itemlist_noteadd_time);
			convertView.setTag(holder);
			holder.del = (Button) convertView
					.findViewById(R.id.itemlist_noteadd_del);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		final objNote note = myArray.get(position);

		holder.title.setText(note.getTitle());
		holder.content.setText(note.getContent());
		holder.date.setText(note.getDate().toString().trim());
		holder.time.setText(note.getTime().toString().trim());
		holder.del.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("" + position);
				SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
				sqLiteHelper.delete(note.getTitle());
				Toast.makeText(context, "Xóa ghi chú: " + note.getTitle(),
						Toast.LENGTH_SHORT).show();
				myArray.remove(position);
				notifyDataSetChanged();
			}
		});
		return convertView;
	}

	static class ViewHolder {
		TextView title;
		TextView content;
		TextView date;
		TextView time;
		Button del;
	}
}
