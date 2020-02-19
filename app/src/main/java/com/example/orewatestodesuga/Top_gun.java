package com.example.orewatestodesuga;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Top_gun extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    public String Channel_ID = "Notification";
    public int Notification_ID = 01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_gun);

        btn1 = findViewById(R.id.call);
        btn2 = findViewById(R.id.msg);
        btn3 = findViewById(R.id.bknm);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String No = "01635057324";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + No));
                final int REQUEST_PHONE_CALL = 1;
                String num = "01635057324";
                intent.setData(Uri.parse("tel:" + num));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(Top_gun.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(Top_gun.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                    } else {
                        startActivity(intent);
                    }
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = "01635057324";
                String msg = "Vai Ticket Lagbo";
                final int REQUEST_SEND_SMS = 1;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(Top_gun.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(Top_gun.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SEND_SMS);
                    } else {
                        SmsManager sms = SmsManager.getDefault();

                        sms.sendTextMessage(no, null, msg, null, null);

                        Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                                Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Top_gun.this);
                alertDialogBuilder.setMessage("Are you sureYou wanted to make this Purchase");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                notificationMethod();

                            }
                        });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }

            private void notificationMethod() {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Top_gun.this, Channel_ID)
                        .setContentTitle("Booking")
                        .setContentText("Purchase Confirmed")
                        .setSmallIcon(R.drawable.ic_local_atm_black_24dp)
                        .setDefaults(NotificationCompat.DEFAULT_ALL);
                NotificationManagerCompat notificationcompat = NotificationManagerCompat.from(Top_gun.this);
                notificationcompat.notify(Notification_ID, builder.build());
            }
        });



    }
}



