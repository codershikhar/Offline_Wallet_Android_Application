package com.example.shikhar420.mobilepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AllOptionsActivity extends AppCompatActivity {
    static boolean internet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_options);

        internet = isInternetAvailable();

        if(!internet)
        {
            ImageView img = (ImageView) findViewById(R.id.imageButton_send);
            img.setImageResource(R.drawable.mobilepaylogoonlynointernet);
        }
    }

    public void sendOnClicked(View view)
    {
        if(!internet)
        {
            Toast.makeText(getApplicationContext(), "No Internet Connection!", Toast.LENGTH_LONG).show();
        }
    }

    public void scanQROnClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), QRChoiceActivity.class);
        startActivity(intent);
    }

    public void walletOnClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), WalletActivity.class);
        startActivity(intent);
    }

    public void onClickBluetoothTransfer(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MainBluetoothActivity.class);
        startActivity(intent);
    }

    public void onClickAccount(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
        startActivity(intent);
    }

    public boolean isInternetAvailable() {
        try {
            final InetAddress address = InetAddress.getByName("www.google.com");
            return true;
        } catch (Exception e) {
            // Log error
        }
        return false;
    }
}