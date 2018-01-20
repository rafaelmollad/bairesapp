package com.example.android.bairesapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by Rafael on 17/1/2018.
 */

public class PhrasesArrayAdapter extends ArrayAdapter<ListItemObject> {

    Typeface tf;


    public PhrasesArrayAdapter(Context context, ArrayList<ListItemObject> listItemObject, String font) {
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
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.phrase_item, parent, false);
        }

        ImageView leftIcon = (ImageView) convertView.findViewById(R.id.left_icon);
        TextView englishPhrase = (TextView) convertView.findViewById(R.id.english_phrase);
        TextView spanishPhrase = (TextView) convertView.findViewById(R.id.spanish_phrase);

        leftIcon.setImageResource(currentItem.getIconImage());
        englishPhrase.setText(currentItem.getEnglishText());
        spanishPhrase.setText(currentItem.getSpanishText());


        // Return the completed view to render on screen
        return convertView;
    }
}
