package com.example.mareklaskowski.workshop2starter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //greeting
        TextView text = (TextView) findViewById(R.id.greeting);
        String value = getIntent().getStringExtra("greeting");
        int pinNumber = getIntent().getIntExtra("number", -1);
        text.setText(value);

        //display name from bundle object
        Bundle bundle = getIntent().getExtras();
        String myName = bundle.getString("my name");
        TextView txt = (TextView) findViewById(R.id.MyName);
        txt.setText("My name is" + " " + myName);

        //display student info
        int StudentId = bundle.getInt("student id");
        TextView pin = (TextView) findViewById(R.id.studentMsg);
        pin.setText("My student id is" + " " + StudentId + " " + "and PIN number is" + " " + pinNumber);

    }
}
