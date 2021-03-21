package com.example.tmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.skt.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        TMapView tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "01df9854-ba40-4023-a9f3-79957242b223" );
        relativeLayout.addView( tMapView );
        setContentView(relativeLayout);
    }
}
