package com.example.shikhar420.mobilepay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickForgotPassword(View view)
    {
        Toast.makeText(getApplicationContext(), "Chutiya!!!", Toast.LENGTH_LONG).show();
    }
}
