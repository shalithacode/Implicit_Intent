package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1= findViewById(R.id.btn1);

        Intent i= new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(i.EXTRA_EMAIL,new String[]{"someone@gmail.com"});
        i.putExtra(i.EXTRA_SUBJECT, "This is our text subject");
        i.putExtra(i.EXTRA_TEXT,"This is our Email body");
        i.setType("text/plane");
        final Intent chooser=Intent.createChooser(i,"Send mail by this app");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               startActivity(chooser);
            }
        });

    }
}