package com.pa.ipv01.pacalendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pa.ipv01.resource.Horoscoperes;
import com.pa.pacalendar.R;

public class HoroscopeDetail extends Activity {
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.horoscopedetail);

		webView = (WebView) findViewById(R.id.horoscope_webview);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

		});
		for (int i = 0; i < Horoscoperes.tuvi.length; i++) {
			if (Horoscope.isHoroscope == Horoscoperes.tuvi[i]) {
				webView.loadUrl(Horoscoperes.tuviUrl[i]);
			}
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		finish();
	}

}
