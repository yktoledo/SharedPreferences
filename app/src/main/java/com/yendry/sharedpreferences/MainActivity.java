package com.yendry.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   EditText txtName, txtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txtName = (EditText) findViewById(R.id.editText);
        txtPhone = (EditText) findViewById(R.id.editText2);


    }
    @Override
    protected void onStop(){
        super.onStop();
        SharedPreferences settings = getSharedPreferences("File", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name", txtName.getText().toString());
        editor.putString("phone", txtPhone.getText().toString());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences settings = getSharedPreferences("File", MODE_PRIVATE);
        String name = settings.getString("name", "No text");
        String phone = settings.getString("phone", "No text");
        txtName.setText(name);
        txtPhone.setText(phone);

    }
}
