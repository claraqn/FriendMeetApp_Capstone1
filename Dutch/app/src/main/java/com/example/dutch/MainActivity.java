package com.example.dutch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button addBtn;
    Button sResultBtn;
    Button deleteBtn;
    String name;
    Map<String,?> totalValue;
    String setence;
    String setence1;
    String setence2;
    String payer;
    String finalsent;
    String dataList="";
    int right;


    static  private  String SHARE_NAME="SHARE_PREF";
    static SharedPreferences sharePref=null;
    static SharedPreferences.Editor editor=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn= (Button)findViewById(R.id.addBtn) ;
        sResultBtn=(Button)findViewById(R.id.sResultBtn);
        deleteBtn=(Button)findViewById(R.id.deleteBtn);

        // 빈 데이터 리스트 생성.
        final ArrayList<String> items = new ArrayList<String>() ;
        // ArrayAdapter 생성. 아이템 View를 선택(single choice)가능하도록 만듦.
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items) ;
        // listview 생성 및 adapter 지정.
        final ListView listview = (ListView) findViewById(R.id.listview1) ;
        listview.setAdapter(adapter);


        //final ArrayList<String> finallist = new ArrayList<String>() ;

        sharePref=getSharedPreferences(SHARE_NAME, MODE_PRIVATE);
        editor=sharePref.edit();

        // 코드 계속 ...
        addBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),FormActivity.class);
                startActivity(intent);
                // 아이템 추가.
            }
        }) ;

        sResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listData();
                Intent intent2= new Intent(getApplicationContext(),AllresultActivity.class);
                intent2.putExtra("sent",dataList);
                startActivityForResult(intent2, 3);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
                Intent intent3=new Intent(getApplicationContext(),AllresultActivity.class);
                intent3.putExtra("delete",1);
                startActivityForResult(intent3,5);
            }
        });


        if (getIntent() != null) {
                name = getIntent().getStringExtra("name");
                setence1 = getIntent().getStringExtra("sentence1");
                setence2 = getIntent().getStringExtra("sentence2");
                payer = getIntent().getStringExtra("payer");

                if (setence2 != null) {
                    setence = setence2;
                } else {
                    setence = setence1;
                }

                finalsent = "가게이름:" + name +"/"+ setence + "결제자:" + payer + "\n";
                saveData();

//            finalsent="가게이름:"+name+setence1+setence2+"결제자:"+payer+"\n";
//            saveData();

                int count;
                count = adapter.getCount();
                // 아이템 추가.

                // 아이템 추가.
                items.add("LIST");

                // listview 갱신
                adapter.notifyDataSetChanged();
        }

    }

    public void saveData(){
        //editor.putString("name"+name, name);
        editor.putString("final"+name,finalsent);
        editor.apply();
    }

    public void listData(){
        totalValue = sharePref.getAll();

        for(Map.Entry<String,?> entry : totalValue.entrySet()){
            dataList+=entry.getValue().toString()+"\n";
        }

    }

    public void deleteData(){
        editor.clear();
        editor.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 3){
            if (resultCode == 4){
                //deleteData();

            }

        }

    }

}
