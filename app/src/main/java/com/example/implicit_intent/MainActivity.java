package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.MailTo;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText maintxt;
    EditText subtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maintxt =findViewById (R.id.main);
        subtxt = findViewById(R.id.sub);
        btn1= findViewById(R.id.btn1);




        btn1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(maintxt.getText())) {
                    /**
                     *   You can Toast a message here that the Username is Empty
                     **/

                    maintxt.setError("First name is required!");
                } else {


                    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                        //we are connected to a network


                        Intent i = new Intent(Intent.ACTION_SEND);
                        String sub_message = subtxt.getText().toString();
                        i.setData(Uri.parse("mailto:"));
                        i.putExtra(i.EXTRA_EMAIL, new String[]{"someone@gmail.com"});
                        i.putExtra(i.EXTRA_SUBJECT, maintxt.getText().toString());
                        i.putExtra(i.EXTRA_TEXT, sub_message);
                        i.setType("text/plane");
                        final Intent chooser = Intent.createChooser(i, "Send mail by this app");

                        startActivity(chooser);
                    } else
                        Toast.makeText(getApplicationContext(), "internet connection is not available", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                }

            } });

    }
}