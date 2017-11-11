package com.example.shikhar420.mobilepay;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AllOptionsActivity extends AppCompatActivity {
    static boolean internet = false;
    static String BTString = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_options);

        if(BTString.equals("Done"))
        {
            Toast.makeText(getApplicationContext(), "BT Transfer Complete", Toast.LENGTH_LONG);
            BTString = "";
        }

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
        }else
        {
            Intent intent = new Intent(getApplicationContext(), SendMoneyToAccountActivity.class);
            startActivity(intent);
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
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public void profileOnClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
    }
}