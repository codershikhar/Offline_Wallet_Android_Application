package com.example.shikhar420.mobilepay;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class QRChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrchoice);
    }

    public void qrSendOnclick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), QRScannerActivity.class);
        startActivity(intent);
    }
}
