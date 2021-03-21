package com.example.dutch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AllresultActivity extends AppCompatActivity {

    String finalresult;
    TextView finalresultTv;
    Button gobacklistBtn2;
    int right=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allresult_main);

        finalresultTv=findViewById(R.id.finalresultTv);
        gobacklistBtn2=(Button)findViewById(R.id.gobacklistBtn2);

        if(right==0){
            Intent intent=getIntent();
            finalresult=intent.getStringExtra("sent");
            finalresultTv.setText(finalresult);
        }



        gobacklistBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                setResult(4,intent);
                finish();
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 5){
            right=1;
        }

    }

}
