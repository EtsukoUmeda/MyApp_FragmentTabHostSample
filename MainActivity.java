package com.example.e2ko777.fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import static com.example.e2ko777.fragment.R.*;
import static com.example.e2ko777.fragment.R.drawable.tab_center;
import static com.example.e2ko777.fragment.R.drawable.tab_left;
public class MainActivity extends FragmentActivity implements TabHost.OnTabChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        FragmentTabHost host = (FragmentTabHost) findViewById(android.R.id.tabhost);
        host.setup(this, getSupportFragmentManager(), id.content);
        TabSpec tabSpec1 = host.newTabSpec("tab1");
        Button button1 = new Button(this);
        button1.setBackgroundResource(tab_left);
        tabSpec1.setIndicator("１円の力");
        Bundle bundle1 = new Bundle();
        bundle1.putString("name", "Tab1");
        host.addTab(tabSpec1, Fragment1.class, bundle1);
        host.setOnTabChangedListener(this);
        TabSpec tabSpec2 = host.newTabSpec("tab2");
        Button button2 = new Button(this);
        button2.setBackgroundResource(tab_center);
        tabSpec2.setIndicator("ここ読め");
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", "Tab2");
        host.addTab(tabSpec2, Fragment2.class, bundle2);
        host.setOnTabChangedListener(this);
    }
    @Override
    public void onTabChanged(String tabId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(tabId.equals("tab1")){
        fragmentTransaction.replace(id.content, new Fragment1());
        fragmentManager.popBackStack();
        }else {
            if (tabId.equals("tab2")){
                fragmentTransaction.replace(id.content,  new Fragment2());
                fragmentManager.popBackStack();
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}}

