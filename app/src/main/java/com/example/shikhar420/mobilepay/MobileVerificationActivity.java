package com.example.shikhar420.mobilepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MobileVerificationActivity extends AppCompatActivity {
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_verification);
        ed = (EditText) findViewById(R.id.editText_mobileNumber);
    }

    public void verifyOTP(View view)
    {
        String num = ed.getText().toString();
        if(num.length() != 10)
        {
            Toast.makeText(getApplicationContext(), "Enter Valid Mobile Number!", Toast.LENGTH_SHORT).show();
        }else
        {
            OTPActivity.number = num;
            Intent intent = new Intent(getApplicationContext(), OTPActivity.class);
            startActivity(intent);
        }
    }

    public void onclickTnC(View view)
    {
        Toast.makeText(getApplicationContext(), "TnC yet to be Defined", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//        startActivity(intent);
    }
}
