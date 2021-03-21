package com.example.dutch;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowresultActivity extends AppCompatActivity {

    TextView nametv;
    TextView payertv;
    TextView moneytv;
    TextView randomtv;
    Button gobacklistBtn;


    String name;
    String payer;
    int money;
    int member;
    int result;
    int result2;
    int randommem;
    String[] randomone;
    String sentence1;
    String sentence2;
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showresult_main);

        nametv=findViewById(R.id.nametv);
        payertv=findViewById(R.id.payertv);
        moneytv=findViewById(R.id.moneytv);
        randomtv=findViewById(R.id.randomtv);
        gobacklistBtn=findViewById(R.id.gobacklistBtn);



        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        payer=intent.getStringExtra("payer");
//        if(money!=0 && member!=0) {
//            money = Integer.parseInt(intent.getStringExtra("money"));
//            member = Integer.parseInt(intent.getStringExtra("member"));
//        }
        money=intent.getIntExtra("money",1);
        member=intent.getIntExtra("member",2);

        nametv.setText(name);
        payertv.setText(payer);
        moneytv.setText(""+money);



        if (money % member == 0) {
            if(intent.hasExtra("result")) {
                result = getIntent().getIntExtra("result", 3);
                sentence1 = " 전부:" + result + "\n나머지금액이 없습니다.\n";
                randomtv.setText(sentence1);
            }

        } else {
            if(intent.hasExtra("result2") && intent.hasExtra("randommem")){
                result2 = getIntent().getIntExtra("result2",4);
                randommem = getIntent().getIntExtra("randommem",5);
                randomone = intent.getStringArrayExtra("randomList");
                if(randomone!=null&&randomone[r]!=null) {
                    r = (int) (Math.random() * randomone.length);
                    sentence2 = randomone[r] + " : " + randommem + "\n나머지 인원:" + result2;

                }
                randomtv.setText(sentence2);
            }
        }


        gobacklistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("sentence1",sentence1);
                intent.putExtra("sentence2",sentence2);
                intent.putExtra("payer",payer);
                startActivity(intent);
            }
        });







    }
}
