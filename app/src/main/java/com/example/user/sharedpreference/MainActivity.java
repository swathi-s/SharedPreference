package com.example.user.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
    }


    public void save(View view) {
        SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString("name",userName.getText().toString());
        editor.putString("password",password.getText().toString());
        Log.d("entered","Username is "+userName.getText().toString());
        Log.d("entered","Password in main "+password.getText().toString());

        editor.commit();
        Toast.makeText(this,"Data has been saved successfully",Toast.LENGTH_SHORT).show();
    }

    public void next(View view) {

        Toast.makeText(this,"Next button has clicked",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,ActivityB.class);
        startActivity(intent);
    }
}
