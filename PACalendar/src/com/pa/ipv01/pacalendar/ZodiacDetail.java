package com.pa.ipv01.pacalendar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

import com.pa.ipv01.resource.Zodiacres;
import com.pa.pacalendar.R;

public class ZodiacDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.zodiacdetail);

		for (int i = 0; i < Zodiacres.cunghd.length; i++) {
			if (Zodiac.isClicked.equals(Zodiacres.cunghd[i])) {
				WebView webView = new WebView(this);
				webView.getSettings().setJavaScriptEnabled(true);
				webView.loadUrl(Zodiacres.cunghdUrl[i]);
				webView.setBackgroundColor(Color.TRANSPARENT);
//				setContentView(webView);

			}
		}
	}
}
