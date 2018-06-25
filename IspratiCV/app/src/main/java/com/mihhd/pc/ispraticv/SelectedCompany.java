package com.mihhd.pc.ispraticv;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectedCompany extends AppCompatActivity {

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_company);

        final Context context = this;

        button1 = findViewById(R.id.Fragment1);
        button2 = findViewById(R.id.Fragment2);

        button1.setBackgroundColor(Color.rgb(230,230,230));
        button1.setTextColor(Color.rgb(51, 51, 204));

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(context,MainActivity.class);
//                startActivity(i);
//            }
//        });
    }

    public void ChangeFragment(View view){
        Fragment fragment;
        CompanyDetails companyDetails = new CompanyDetails();
        CompanyMap companyMap = new CompanyMap();
        MapsActivity mapsActivity = new MapsActivity();

        if(view == findViewById(R.id.Fragment1)){
            fragment = companyDetails;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_place, fragment);
            fragmentTransaction.commit();

            button1.setBackgroundColor(Color.rgb(230,230,230));
            button1.setTextColor(Color.rgb(51, 51, 204));
            button2.setBackgroundColor(Color.rgb(204,204,204));
            button2.setTextColor(Color.BLACK);

        }

        if(view == findViewById(R.id.Fragment2)){
            fragment = companyMap;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_place, fragment);
            fragmentTransaction.commit();

            button2.setBackgroundColor(Color.rgb(230,230,230));
            button2.setTextColor(Color.rgb(51, 51, 204));
            button1.setBackgroundColor(Color.rgb(204,204,204));
            button1.setTextColor(Color.BLACK);
        }
    }
}
