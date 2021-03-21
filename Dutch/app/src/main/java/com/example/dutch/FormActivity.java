package com.example.dutch;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FormActivity extends AppCompatActivity {
    EditText nameEdt;
    EditText payerEdt;
    EditText moneyEdt;
    TextView peopleTv;
    Button btnInput;
    Button finalBtn;
    ArrayList<String> ReceiveArr;

    String name;
    String payer;
    int money;
    int member;
    int result;
    int result2;
    int randommem;
    String[] a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_main);

        nameEdt=findViewById(R.id.nameEdt);
        payerEdt=findViewById(R.id.payerEdt);
        moneyEdt=findViewById(R.id.moneyEdt);
        peopleTv=findViewById(R.id.peopleTv);
        btnInput=findViewById(R.id.btnInput);
        finalBtn=findViewById(R.id.finalBtn);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),InputActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        finalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=nameEdt.getText().toString();
                payer=payerEdt.getText().toString();
                money=Integer.parseInt(moneyEdt.getText().toString());
                member=(ReceiveArr.size())+1;
                if(money%member==0){
                    result= money/member;
                }
                else{
                    result2=money/member;
                    int conresult=result2/100;
                    int conresult2=conresult*100;
                    randommem=(money-(conresult2*(member-1)));
                }
                Intent intent=new Intent(getApplicationContext(),ShowresultActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("payer", payer);
                intent.putExtra("money",money);
                intent.putExtra("member",member);
                intent.putExtra("result",result);
                intent.putExtra("result2",result2);
                intent.putExtra("randommem",randommem);
                intent.putExtra("randomList", a);

                startActivity(intent);


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        peopleTv=findViewById(R.id.peopleTv);
        if(requestCode == 1){
            if (resultCode == 2 && data!=null){
                ReceiveArr= data.getStringArrayListExtra("nameList");
//                Integer[] place = al3.toArray(new Integer[al.size()]);
                if(ReceiveArr!=null) {
                    a = ReceiveArr.toArray(new String[ReceiveArr.size()]);
                    peopleTv.setText(Arrays.toString(a));
                    Intent intent=new Intent(getApplicationContext(),ShowresultActivity.class);
                }
                else{
                    peopleTv.setText("실패");
                }

//
//                if(ReceiveArr!=null) {
//                    array = new String[ReceiveArr.size()];
//                    int size = 0;
//                    for (String temp : ReceiveArr) {
//                        array[size++] = temp;
//                    }
//
//                    peopleTv.setText(Arrays.toString(array));
//                }



            }



        }
    }
}
