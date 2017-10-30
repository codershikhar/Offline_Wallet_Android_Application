package com.example.shikhar420.mobilepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class OTPActivity extends AppCompatActivity {
    static String number = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        TextView tv = (TextView) findViewById(R.id.textView_displaynumber);
        final EditText et = (EditText) findViewById(R.id.editText_enterotp);
        String number1 = "(+91) ";
        number1 = number1 + number.substring(0,3) + "-\n" + number.substring(3, 6) + "-" + number.substring(6);
        tv.setText(number1);
        new Thread(new Runnable() {
            public void run()
            {
                while(et.getText().toString().length() < 5)
                {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                Toast.makeText(getApplicationContext(), "OTP Verification Successful!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), BankSelectActivity.class);
                startActivity(intent);
            }
        }).start();
    }
}
