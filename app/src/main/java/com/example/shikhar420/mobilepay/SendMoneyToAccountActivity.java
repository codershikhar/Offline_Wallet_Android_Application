package com.example.shikhar420.mobilepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SendMoneyToAccountActivity extends AppCompatActivity {

    static String s;
    static String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money_to_account);
    }

    public void goToAllOptionsOnClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AllOptionsActivity.class);
        startActivity(intent);
    }

    public void proceedOnClick(View view)
    {
        EditText et = (EditText) findViewById(R.id.editText_enterMobileNo);
        EditText et1 = (EditText) findViewById(R.id.editText_enterAmmount);

        s = et.getText().toString();
        s1 = et1.getText().toString();

        setContentView(R.layout.money_transfer_success);
        TextView et2 = (TextView) findViewById(R.id.textView_monetTO_mobile);
        TextView et3 = (TextView) findViewById(R.id.textView_moneyAmount);
        et2.setText("Mobile No : " + s);
        et3.setText("Ammount : " + s1 + " Rs.");

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
}
