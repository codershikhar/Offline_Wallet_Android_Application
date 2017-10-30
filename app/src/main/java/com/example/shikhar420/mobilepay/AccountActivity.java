package com.example.shikhar420.mobilepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void goToAllOptionsOnClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AllOptionsActivity.class);
        startActivity(intent);
    }
}
