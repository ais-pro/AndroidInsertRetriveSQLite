package com.example.aisuv.databaseinsertretrive;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btn;
    Button showBtn;
    EditText t;
    DBhelper dBhelper;
    String str,data;
    Long l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init components
        btn=(Button) findViewById(R.id.saveBtn);
        showBtn=(Button) findViewById(R.id.showBtn);
        t=(EditText) findViewById(R.id.editText);
        dBhelper=new DBhelper(this);

        //action
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str=t.getText().toString();
                l=dBhelper.insert(str);
                if(l==-1){
                    Toast.makeText(MainActivity.this,"Error while save data", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Save successfully:#"+l,Toast.LENGTH_LONG).show();
                }
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=dBhelper.Show();
                cursor.moveToLast();
                data=cursor.getString(1);
                Toast.makeText(MainActivity.this,"Last inserted value is:"+data,Toast.LENGTH_LONG).show();
            }
        });
    }
}
