package com.mihhd.pc.ispraticv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] emails;
    String[] descriptions;
    String[] stringLocations;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emails = getResources().getStringArray(R.array.companies_email);
        descriptions = getResources().getStringArray(R.array.companies_description);
        stringLocations = getResources().getStringArray(R.array.company_locations);

        listView = (ListView) findViewById(R.id.companies);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.companies_names));

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SelectedCompany.class);
                intent.putExtra("Company", listView.getItemAtPosition(position).toString());
                intent.putExtra("Email", emails[position]);
                intent.putExtra("Description", descriptions[position]);

                String splitted[] = stringLocations[position].split(",");
                latitude = Double.parseDouble(splitted[0]);
                longitude = Double.parseDouble(splitted[1]);

                intent.putExtra("Latitude", latitude);
                intent.putExtra("Longitude", longitude);

                startActivity(intent);
            }
        });

    }
}
