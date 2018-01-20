package com.example.android.bairesapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NightFragment extends Fragment {


    public NightFragment() {
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
        arrayOfObjects.add(new ListItemObject(R.string.name_amerika, R.drawable.amerika, R.string.type_lgbt_night_club, R.string.description_amerika, "geo:0,0?q=America, boliche, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_apple, R.drawable.apple, R.string.type_night_club, R.string.description_apple, "geo:0,0?q=Apple, boliche, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_barfly, R.drawable.barfly, R.string.type_night_club, R.string.description_barfly, "geo:0,0?q=Barfly, boliche, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_club_bahrein, R.drawable.club_bahrein, R.string.type_night_club, R.string.description_club_bahrein, "geo:0,0?q=Club bahrein, boliche, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_crobar, R.drawable.crobar, R.string.type_night_club, R.string.description_crobar, "geo:0,0?q=Crobar, boliche, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_esperanto, R.drawable.esperanto, R.string.type_night_club, R.string.description_esperanto, "geo:0,0?q=Esperanto, boliche, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_niceto_club, R.drawable.nicetoclub, R.string.type_night_club, R.string.description_niceto_club, "geo:0,0?q=Niceto club, boliche, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_porto_soho, R.drawable.porto_soho, R.string.type_night_club, R.string.description_porto_soho, "geo:0,0?q=Porto Soho, boliche, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_vita, R.drawable.vita, R.string.type_night_club, R.string.description_vita, "geo:0,0?q=Vita, boliche, Buenos Aires, Argentina"));
        arrayOfObjects.add(new ListItemObject(R.string.name_honduras_hollywood, R.drawable.honduras_hollywood, R.string.type_night_club, R.string.description_honduras_hollywood, "geo:0,0?q=Honduras Hollywood, boliche, Buenos Aires, Argentina"));

        // Instantiate CustomArrayAdapter
        CustomArrayAdapter adapter = new CustomArrayAdapter(getActivity(), arrayOfObjects, "font/Poppins-Regular.ttf");

        // Attach adapter to ListView
        listView.setAdapter(adapter);

        // Return listView(RootView)
        return rootView;
    }

}
