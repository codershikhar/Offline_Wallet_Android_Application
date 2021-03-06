package com.example.shikhar420.mobilepay;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class QRScannerSenderActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView scannerView;
    String amount = "";
    String recieverID = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(R.layout.activity_qrscanner_sender);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if(checkPermission())
            {
                Toast.makeText(QRScannerSenderActivity.this, "Permission is granted", Toast.LENGTH_LONG).show();
            }else
            {
                requestPermission();
            }
        }

        scan();
        //Intent gotoQR = new Intent(this,Recivers_qr.class);
        //startActivity(gotoQR);
    }

    void scan(){
        new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        Toast.makeText(this,intentResult.getContents(),Toast.LENGTH_LONG).show();
        recieverID = intentResult.getContents().toString();

        Button btn = (Button) findViewById(R.id.button_generate_qr);
        btn.setVisibility(View.VISIBLE);
        EditText editText = (EditText) findViewById(R.id.edittext_amount);
        editText.setVisibility(View.VISIBLE);

    }
    void generate_qr(View view){
        //Intent intent = new Intent(this,QR_money_transfer_by_sender.class);
        //startActivity(intent);
        //intent.putExtra("data",recieverID+":1234567891");
        EditText editText = (EditText) findViewById(R.id.edittext_amount);
        amount = editText.getText().toString();
        IntentIntegrator integrator=new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.shareText("Shikhar Agrawal" + ":1234567891:Rs."+amount);

        //new IntentIntegrator(this).setPrompt("Press Back Once Done").shareText(recieverID + ":1234567891:"+amount);
    }

    private void requestPermission()
    {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }

    private boolean checkPermission()
    {
        return (ContextCompat.checkSelfPermission(QRScannerSenderActivity.this, CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        TextView reciever_disp_textview =(TextView) findViewById(R.id.textView3);
//        String reciev = ""+recieverID;
//        reciever_disp_textview.setText(reciev);
    }

    public void onRequestPermissionResult(int requestCode, String permission[], int grantResults[])
    {
        switch (requestCode)
        {
            case REQUEST_CAMERA:
                if(grantResults.length > 0)
                {
                    boolean cameraAccepted  = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if(cameraAccepted)
                    {
                        Toast.makeText(QRScannerSenderActivity.this, "Permission is granted", Toast.LENGTH_LONG).show();
                    }else
                    {
                        Toast.makeText(QRScannerSenderActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                        {
                            if (shouldShowRequestPermissionRationale(CAMERA))
                            {
                                displayAlertMessage("You need to allow access for both permissions",
                                        new DialogInterface.OnClickListener(){
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CAMERA}, REQUEST_CAMERA);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission())
            {
                if (scannerView == null)
                {
                    scannerView = new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);
                scannerView.startCamera();
            }
        }
    }

    public void displayAlertMessage(String message, DialogInterface.OnClickListener listner)
    {
        new AlertDialog.Builder(QRScannerSenderActivity.this)
            .setMessage(message)
                .setPositiveButton("OK", listner)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    public void handleResult(final Result result)
    {
        final String scanResult = result.getText();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                scannerView.resumeCameraPreview(QRScannerSenderActivity.this);
            }
        });
        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scanResult));
                startActivity(intent);
            }
        });
        builder.setMessage(scanResult);
        AlertDialog alert = builder.create();
        alert.show();
    }
}
