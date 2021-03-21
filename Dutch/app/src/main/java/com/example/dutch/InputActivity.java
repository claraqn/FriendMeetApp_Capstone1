package com.example.dutch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class InputActivity extends AppCompatActivity {
    ListView inputList;
    EditText edtName;
    Button btnInput2;
    Button btnInput3;
    ArrayAdapter adapter;
    ArrayList<String> nameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputname_main);

        inputList=findViewById(R.id.inputList);
        edtName=findViewById(R.id.edtName);
        btnInput2=findViewById(R.id.btnInput2);
        btnInput3=findViewById(R.id.btnInput3);

        nameList=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, nameList);
        inputList.setAdapter(adapter);
        btnInput2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=edtName.getText().toString();
                nameList.add(data);
                edtName.setText("");
                adapter.notifyDataSetChanged();
            }
        });
        btnInput3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FormActivity.class);
                intent.putExtra("nameList", nameList);
                setResult(2,intent);
                finish();
            }
        });


    }
}
