package com.pa.ipv01.pacalendar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

import com.pa.ipv01.resource.VanKhanDetailres;
import com.pa.pacalendar.R;

public class VanKhanDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.vankhandetail);

		for (int i = 0; i < VanKhanDetailres.vkresource.length; i++) {
			if (VanKhan.isClicked.equals(VanKhanDetailres.vkresource[i])) {
				WebView webView = new WebView(this);
				webView.getSettings().setJavaScriptEnabled(true);
				webView.loadUrl(VanKhanDetailres.vankhanUrl[i]);
				System.out.println(""+VanKhanDetailres.vankhanUrl[i]);
				webView.setBackgroundColor(Color.TRANSPARENT);
				setContentView(webView);
			}
		}
	}
}
