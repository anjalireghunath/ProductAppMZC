package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

public class AddProductActivity extends AppCompatActivity {
EditText ed1,ed2,ed3;
AppCompatButton b1,b2;
String getProCode,getProName,getPrice;
DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ed1=(EditText) findViewById(R.id.procodes);
        ed2=(EditText) findViewById(R.id.pronames);
        ed3=(EditText) findViewById(R.id.pricee);
        b1=(AppCompatButton) findViewById(R.id.submitbtn);
        b2=(AppCompatButton) findViewById(R.id.backmenubtn);
        dbHelper=new DbHelper(this);
        dbHelper.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getProCode=ed1.getText().toString();
                getProName=ed2.getText().toString();
                getPrice=ed3.getText().toString();
                boolean result=dbHelper.insertdata(getProCode,getProName,getPrice);
                if(result==true){
                    Toast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "failed to insert data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}