package com.pa.ipv01.pacalendar;


import com.pa.pacalendar.R;

import android.app.LoaderManager;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;

/**
 * Created by Ipv01 on 1/19/2015.
 */
@SuppressWarnings({ "unused", "deprecation" })
public class MainActivity extends TabActivity implements TabHost.OnTabChangeListener {

    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.main);

        // Get TabHost Refference
        tabHost = getTabHost();

        // Set TabChangeListener called when tab changed
        tabHost.setOnTabChangedListener(this);

        TabHost.TabSpec spec;
        Intent intent;

        /************* Tab ngay hien tai ************/
        // Create  Intents to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, DayNow.class);
        spec = tabHost.newTabSpec("Tab day now").setIndicator("")
                .setContent(intent);

        //Add intent to tab
        tabHost.addTab(spec);

        /************* Tab chon ngay ************/
        intent = new Intent().setClass(this, DayChoice.class);
        spec = tabHost.newTabSpec("Tab day choice").setIndicator("")
                .setContent(intent);
        tabHost.addTab(spec);

        /************* Tab lich thang ************/
        intent = new Intent().setClass(this, MonthCalendar.class);
        spec = tabHost.newTabSpec("Tab month").setIndicator("")
                .setContent(intent);
        tabHost.addTab(spec);

        /************* Tab ghi chu ************/
        intent = new Intent().setClass(this, NoteAdd.class);
        spec = tabHost.newTabSpec("Tab note").setIndicator("")
                .setContent(intent);
        tabHost.addTab(spec);

        /************* Tab xem them ************/
        intent = new Intent().setClass(this, OtherView.class);
        spec = tabHost.newTabSpec("Tab other view").setIndicator("")
                .setContent(intent);
        tabHost.addTab(spec);

        // Set drawable images to tab
        tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.btn_chonngay);
        tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.btn_lichthang);
        tabHost.getTabWidget().getChildAt(3).setBackgroundResource(R.drawable.btn_ghichu);
        tabHost.getTabWidget().getChildAt(4).setBackgroundResource(R.drawable.btn_xemthem);

        // Set Tab1 as Default tab and change image
        tabHost.getTabWidget().setCurrentTab(0);
        tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.btn_ngayhientai_down);
    }

    @Override
    public void onTabChanged(String tabId) {

        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            if(i==0)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.btn_ngayhientai);
            else if(i==1)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.btn_chonngay);
            else if(i==2)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.btn_lichthang);
            else if(i==3)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.btn_ghichu);
            else if(i==4)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.btn_xemthem);
        }


        Log.i("tabs", "CurrentTab: " + tabHost.getCurrentTab());

        if(tabHost.getCurrentTab()==0)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.btn_ngayhientai_down);
        else if(tabHost.getCurrentTab()==1)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.btn_chonngay_down);
        else if(tabHost.getCurrentTab()==2)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.btn_lichthang_down);
        else if(tabHost.getCurrentTab()==3)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.btn_ghichu_down);
        else if(tabHost.getCurrentTab()==4)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.btn_xemthem_down);
    }
}
