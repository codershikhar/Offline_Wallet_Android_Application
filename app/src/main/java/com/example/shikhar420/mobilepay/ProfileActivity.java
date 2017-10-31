package com.example.shikhar420.mobilepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {
    static int loggedin = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if(loggedin == 1)
        {
            Toast.makeText(getApplicationContext(), "Already Logged In!", Toast.LENGTH_SHORT).show();
            loggedin = 0;
        }
    }

    public void onClickLogout(View view) throws IOException {
        FileOutputStream fOut = openFileOutput("login.txt",MODE_WORLD_READABLE);
        String str = "no";
        fOut.write(str.getBytes());
        fOut.close();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    public void onClickNext(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AllOptionsActivity.class);
        startActivity(intent);
    }
}
