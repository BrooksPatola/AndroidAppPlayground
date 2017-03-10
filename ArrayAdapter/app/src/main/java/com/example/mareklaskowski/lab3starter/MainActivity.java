package com.example.mareklaskowski.lab3starter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.button2);
       final AutoCompleteTextView  autoTv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String enteredText = autoTv.getText().toString();
                if (!enteredText.isEmpty()) {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(enteredText);

                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_main);
                    //LayoutParams is a class to specify layout properties when adding a view to a layout
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    linearLayout.addView(textView, layoutParams);
                }



            }
        });
        //TODO: change things so that TextViews are added in response to button clicks
        //TODO: populate the AutoCompleteTextView using an ArrayAdapter for String arrays
         AutoCompleteTextView suggestions = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

         String[] myList = getResources().getStringArray(R.array.topics);

        ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
                    suggestions.setAdapter(adapter);
        }

}
