package com.example.dust;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        //data String배열에 지역명 넣어줌
        String[] data={"서울","부산","대구","인천","광주","대전","울산",
                "경기","강원","충북","충남","전북","전남","세종","경북","경남","제주"};

        //리스트뷰, arrayadapter 선언
        ListView lvList;
        ArrayAdapter arrayAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            lvList=findViewById(R.id.lvList);

            arrayAdapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, data);
            lvList.setAdapter(arrayAdapter);
            lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                // 코드 계속 ...

                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {
                    //클릭한 부분의 내용을 가져와서 String 형태의 strText에 담아줌
                    String strText = (String) parent.getItemAtPosition(position) ;

                    //intent 객체통해 strText(name:local로 지정)담아서 ListActivity.class 로보내줌
                    Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                    intent.putExtra("local",strText); /*송신*/

                    /*intent.putExtra("title", al.get(position).title);*/
                    startActivity(intent);
                }
            }) ;
        }
}
