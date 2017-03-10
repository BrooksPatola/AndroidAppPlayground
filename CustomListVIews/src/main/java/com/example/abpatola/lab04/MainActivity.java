package com.example.abpatola.lab04;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.fitness.data.Goal;

public class MainActivity extends AppCompatActivity {

    //lets declare an array of icons that matches the order of descriptions
    public static int[] images = {R.drawable.bbcnews, R.drawable.reddit, R.drawable.sciencemag};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lets get an array of descriptions from xml (string array resource)

        String[] descriptions = getResources().getStringArray(R.array.description_array);
        //in order to set up or listview we also need an ArrayAdapter
        //this Adaptor needs to use our custom_list layout.
        //Therefore we need to create a custom Arrayadaptor class

        //get a reference to our ListView so we can associate it with our custom ArrayAdapter
        ListView listView = (ListView) findViewById(R.id.listView);
        //create a new MyCustomAdapter
        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(this, descriptions, images);
        //connect the ListView with myCustomAdapter
        listView.setAdapter(myCustomAdapter);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.help_id:
                Toast.makeText(getApplicationContext(), "click who's site you want to visit", Toast.LENGTH_LONG).show();
                return true;
            //case R.id.about_id;


            default:
                return super.onOptionsItemSelected(item);

        }

    }

}
