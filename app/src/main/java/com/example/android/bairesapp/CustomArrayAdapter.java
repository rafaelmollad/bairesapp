package com.example.android.bairesapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by Rafael on 2/1/2018.
 */

public class CustomArrayAdapter extends ArrayAdapter<ListItemObject> {


    Typeface tf;


    public CustomArrayAdapter(Context context, ArrayList<ListItemObject> listItemObject, String font) {
        super(context, 0, listItemObject);
        // Get Poppins font from assets/font
        tf = Typeface.createFromAsset(context.getAssets(), font);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ListItemObject currentItem = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.places_list_item, parent, false);
        }
        // Lookup view for data population
        ImageView backgroundImage = (ImageView) convertView.findViewById(R.id.backgroundImage);
        TextView headerText = (TextView) convertView.findViewById(R.id.headerText);

        // Populate the data into the template view using the data object
        backgroundImage.setImageResource(currentItem.getImageResourceId());
        headerText.setText(currentItem.getName());

        // Set headerText to have Poppins-Regular font
        headerText.setTypeface(tf);

        // Return the completed view to render on screen
        return convertView;
    }

}