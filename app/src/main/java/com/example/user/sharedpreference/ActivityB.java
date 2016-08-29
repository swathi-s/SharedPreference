package com.example.user.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 8/29/2016.
 */
public class ActivityB extends AppCompatActivity {

    public static final String DEFAULTS = "N/A";
    TextView loadUserName, loadPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityb);

        loadUserName = (TextView) findViewById(R.id.editText3);
        loadPassword = (TextView) findViewById(R.id.editText4);

    }


    public void load(View view) {
        SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPreference.getString("name",DEFAULTS);
        String password = sharedPreference.getString("password",DEFAULTS);
        Log.d("entered","name is "+name);
        Log.d("entered","password is "+password);

        if(name.equals(DEFAULTS) || password.equals(DEFAULTS))
        {
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Data Loaded Successfully",Toast.LENGTH_SHORT).show();
            loadUserName.setText(name);
            loadPassword.setText(password);
        }


    }

    public void previous(View view) {

        Toast.makeText(this,"Previous button has clicked",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

