package com.example.shikhar420.mobilepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BankSelectActivity extends AppCompatActivity {
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_select);
        Toast.makeText(getApplicationContext(), "OTP Verification Successful!!", Toast.LENGTH_SHORT).show();
    }

    public void bankselectOnClick(View view)
    {
        setContentView(R.layout.customer_id_input);
        ed = (EditText) findViewById(R.id.editText_customeID);
    }

    public void verifyCustomeID(View view)
    {
        if(ed.getText().toString().length() == 10)
        {
            Intent intent = new Intent(getApplicationContext(), fFetchingAccountInfoActivity.class);
            startActivity(intent);
        }
    }
}