package com.example.abpatola.lab04;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by abpatola on 2/14/2017.
 */

public class MyCustomAdapter extends BaseAdapter {
    //lets declare some instance variables to hold essential data
    String[] descriptions;
    int [] images;
    Context context;

    //constructor to set up our instance variables
    public MyCustomAdapter(MainActivity c, String[] d, int[] i){
        context = c;
        descriptions = d;
        images = i;
    }

    @Override
    public int getCount() {
        return descriptions.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //the android framework will call getView everytime it needs to render your listview
    // int position indicates which row the framework is trying to draw
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View row; // a reference to refer to each row
        //layoutInflator is a class that creates a java obj from the xml layout
        //we get a layoutINflator from the framework by calling getSystemService
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        //use the layoutInflater to create a new View of the correct type (custome_list)
        row = inflater.inflate(R.layout.custom_list, null);
        //get the textview and set its text
        TextView textView = (TextView) row.findViewById(R.id.textView);
        textView.setText(descriptions[position]);
        //get the img view and set its img icon
        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        //we need to add an OnClickListener to respond to user clicks!
        row.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(context, descriptions[position], Toast.LENGTH_LONG).show();
               // Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
               // Intent intent = new Intent(Intent.ACTION_VIEW, uri);
             //   context.startActivity(intent);

                String[] links = context.getResources().getStringArray(R.array.links);
                String url = links[position];
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);



            }
        });
        return row;
    }
}
