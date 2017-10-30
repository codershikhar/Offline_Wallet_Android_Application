package com.example.shikhar420.mobilepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HomeActivity extends AppCompatActivity {
    boolean logged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        try {
            boolean logged = checkLoginStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            logged = checkLoginStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread myThread = new Thread(){
            @Override
            public void run()
            {
                try {
                    sleep(3000);

                    if (logged)
                    {
                        ProfileActivity.loggedin = 1;
                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(intent);
                    }else
                    {
                        Intent intent = new Intent(getApplicationContext(), MobileVerificationActivity.class);
                        startActivity(intent);
                    }
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        myThread.start();
    }

    private boolean checkLoginStatus() throws IOException {
        FileInputStream fin = openFileInput("login.txt");
        int c;
        String temp="";
        while( (c = fin.read()) != -1){
            temp = temp + Character.toString((char)c);
        }
//string temp contains all the data of the file.
        fin.close();
        if(temp.equals("yes"))
                return true;
        return false;
    }
}
