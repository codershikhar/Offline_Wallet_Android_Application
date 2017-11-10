package com.example.shikhar420.mobilepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class QR_money_transfer_by_sender extends AppCompatActivity {

    EditText editText = (EditText) findViewById(R.id.editText2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_money_transfer_by_sender);
    }
    void payback_onclick(View view){
        String money_to_pay = editText.getText().toString();
        Intent intent = new Intent(this,QRScannerSenderActivity.class);
        intent.putExtra("money",money_to_pay);
        startActivity(intent);
    }
}
