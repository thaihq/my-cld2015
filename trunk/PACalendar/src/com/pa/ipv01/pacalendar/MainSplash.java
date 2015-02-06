package com.pa.ipv01.pacalendar;

import com.pa.pacalendar.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainSplash extends Activity{
	ProgressBar pgr;
	int progress=0;
	Handler hand=new Handler();
	static MediaPlayer mplay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		mplay= MediaPlayer.create(this, R.raw.phaohoa);
		mplay.start();
		
		pgr=(ProgressBar)findViewById(R.id.progressBar1);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<4;i++)
				{
					progress+=25;
					hand.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							pgr.setProgress(progress);
							if(progress==pgr.getMax())
							{
								Intent intent=new Intent(getApplicationContext(),MainActivity.class);
								startActivity(intent);
								finish();
							}
						}
					});
					try {
						Thread.sleep(3000);
					} catch (Exception e) {
						// TODO: handle exception
					}
//					finally{
//						finish();
//					}
				}
			}
		}).start();
	}
//
//	@Override
//	protected void onDestroy() {
//		// TODO Auto-generated method stub
//		super.onDestroy();
//		mplay.release();
//		progress=0;
//	}
//
//	@Override
//	protected void onResume() {
//		// TODO Auto-generated method stub
//		super.onResume();
//		mplay.start();
//	}
//
//	@Override
//	protected void onPause() {
//		// TODO Auto-generated method stub
//		super.onPause();
////		finish();
//		mplay.pause();
//	}
//
//	@Override
//	protected void onStop() {
//		// TODO Auto-generated method stub
//		super.onStop();
////		mplay.stop();
//	}
	
}
