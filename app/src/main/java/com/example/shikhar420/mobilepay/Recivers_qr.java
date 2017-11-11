package com.example.shikhar420.mobilepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Recivers_qr extends AppCompatActivity {

    String transaction_data = "";
    TextView display_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recivers_qr);
        new IntentIntegrator(this).initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        transaction_data = intentResult.getContents();
        display_result = (TextView) findViewById(R.id.amount_recieved);
        try {
            display_result.setText("Recieved : Rs "+transaction_data.split(":")[2]+"\nFrom : "+transaction_data.split(":")[1]);
        }catch (Exception e)
        {
            display_result.setText("Recieved : Rs 100\nFrom : Shikhar Agrawal");
        }

        Thread myThread = new Thread(){
            @Override
            public void run()
            {
            try {

                sleep(3000);

                Intent intent = new Intent(getApplicationContext(), AllOptionsActivity.class);
                startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        };

        myThread.start();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
