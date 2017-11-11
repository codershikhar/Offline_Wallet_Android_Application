package com.example.shikhar420.mobilepay;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRChoiceActivity extends AppCompatActivity {
    String transaction_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrchoice);
    }

    public void qrSendOnclick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), QRScannerSenderActivity.class);
        startActivity(intent);
    }

    public void generateQRonclick(View view){
        new IntentIntegrator(this).shareText("1234567890");

        //new IntentIntegrator(this).shareText("1234567890");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent = new Intent(this,Recivers_qr.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,Recivers_qr.class);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        //new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        //new IntentIntegrator(this).initiateScan();
    }
}
