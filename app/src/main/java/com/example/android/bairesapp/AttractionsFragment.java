package com.example.android.bairesapp;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // Get listView reference
       final ListView listView = (ListView) rootView.findViewById(R.id.list);


        /**
         * Listen when user clicks on a listItem
         * from attractions category
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Have a reference of which list item was touched
                ListItemObject item = (ListItemObject) listView.getItemAtPosition(position);

                Intent intent = new Intent(getContext(), PlacesActivity.class);

                // Send image resource ID
                intent.putExtra("PlaceImage", item.getImageResourceId());
                // Send place name
                intent.putExtra("Name", item.getName());
                // Send type of place
                intent.putExtra("TypeOfPlace", item.getTypeOfPlace());
                // Send place description
                intent.putExtra("PlaceDescription", item.getPlaceDescription());

                intent.putExtra("Coordinates", item.getCoordinates());

                startActivity(intent);
            }
        });

        // Create arrayList containing objects instances from ListItemObject.java
        ArrayList<ListItemObject> arrayOfObjects = new ArrayList<ListItemObject>();

        // Populate arrayList
        arrayOfObjects.add(new ListItemObject(R.string.name_la_boca, R.drawable.laboca, R.string.type_neighborhood, R.string.description_la_boca, "geo:0,0?q=La boca, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_planetarium, R.drawable.planetario, R.string.type_planetarium, R.string.description_planetarium, "geo:0,0?q=Planetario Galileo Galilei, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_national_museum, R.drawable.museobellasartes, R.string.type_museum, R.string.description_national_museum, "geo:0,0?q=Museo nacional de bellas artes, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_corrientes, R.drawable.avenidacorrientes, R.string.type_avenue, R.string.description_corrientes_avenue, "geo:0,0?q=Av. Corrientes, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_recoleta_cementery, R.drawable.cementeriorecoleta, R.string.type_cementery, R.string.description_recoleta_cemenetery, "geo:0,0?q=Cementerio de la recoleta, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_japanese_cementery, R.drawable.jardinjapones, R.string.type_garden, R.string.description_japanese_garden, "geo:0,0?q=Jardin japonés, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_malba, R.drawable.malba, R.string.type_museum, R.string.description_malba, "geo:0,0?q=Museo de arte latinoamericano de buenos aires, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_rose_garden_walk, R.drawable.paseodelrosedal, R.string.type_garden, R.string.description_rose_garden_walk, "geo:0,0?q=El rosedal de palermo, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_san_telmo, R.drawable.santelmo, R.string.type_neighborhood, R.string.description_san_telmo, "geo:0,0?q=San telmo, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_colon_theater, R.drawable.teatrocolon, R.string.type_theater, R.string.description_colon_theater, "geo:0,0?q=Teatro colón, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_zajon_granados, R.drawable.zanjongranados, R.string.type_museum, R.string.description_zanjon_granados, "geo:0,0?q=El zanjon, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.puerto_madero, R.drawable.puertomadero, R.string.type_neighborhood, R.string.description_puerto_madero, "geo:0,0?q=Puerto madero, Buenos Aires, Argentina"));

        // Instantiate CustomArrayAdapter
        CustomArrayAdapter adapter = new CustomArrayAdapter(getActivity(), arrayOfObjects, "font/Poppins-Regular.ttf");

        // Attach adapter to ListView
        listView.setAdapter(adapter);

        // Return listView(RootView)
        return rootView;

    }

}

