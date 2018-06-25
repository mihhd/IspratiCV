package com.mihhd.pc.ispraticv;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class CompanyDetails extends Fragment {

    TextView companyName;
    TextView email;
    TextView description;
    ImageView logo;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inf = inflater.inflate(R.layout.fragment_company_details, container, false);
        companyName = inf.findViewById(R.id.txtCompanyName);
        email = inf.findViewById(R.id.txtCompanyEmail);
        description = inf.findViewById(R.id.txtCompayDesc);
        logo = inf.findViewById(R.id.imgLogo);
        button = inf.findViewById(R.id.btnSendActivity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SendEmail.class);
                i.putExtra("Company", companyName.getText());
                i.putExtra("Email", email.getText());
                startActivity(i);
            }
        });
        setText();
        return inf;
    }

    public void setText(){
        Bundle bundle = getActivity().getIntent().getExtras();
        if(bundle!=null){
            companyName.setText(bundle.getString("Company"));
            email.setText(bundle.getString("Email"));
            description.setText(bundle.getString("Description"));
        }
        String s = companyName.getText().toString().toLowerCase();
        int id = getResources().getIdentifier("com.mihhd.pc.ispraticv:drawable/" + s , null, null);
        logo.setImageResource(id);
    }

}
