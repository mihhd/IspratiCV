package com.mihhd.pc.ispraticv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SendEmail extends AppCompatActivity {

    TextView companyName;
    TextView companyEmail;
    String position;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        editText = findViewById(R.id.applicatePosition);
        companyName = findViewById(R.id.company);
        companyEmail = findViewById(R.id.mail);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            companyName.setText(bundle.getString("Company"));
            companyEmail.setText(bundle.getString("Email"));
        }
    }

    public void Send(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String [] array = {companyEmail.getText().toString()};
        intent.putExtra(Intent.EXTRA_EMAIL, array);
        position = editText.getText().toString();
        intent.putExtra(Intent.EXTRA_SUBJECT,"Application for "+position);
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }
}
