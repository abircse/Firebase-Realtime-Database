package com.studioabir.firebasedatabase.firebasedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.studioabir.firebasedatabase.firebasedatabase.model.user;

public class MainActivity extends AppCompatActivity {

    EditText NAME,EMAIL,PHONE,USERNAME,PASSWORD;
    Button INSERTDATA;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NAME = findViewById(R.id.name);
        EMAIL = findViewById(R.id.email);
        PHONE = findViewById(R.id.phone);
        USERNAME = findViewById(R.id.username);
        PASSWORD = findViewById(R.id.password);
        INSERTDATA = findViewById(R.id.insertdata);



        INSERTDATA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                savedata();


            }
        });

    }

    public void savedata() {

        String N = NAME.getText().toString();
        String E = EMAIL.getText().toString();
        String P = PHONE.getText().toString();
        String UN = USERNAME.getText().toString();
        String PS = PASSWORD.getText().toString();

        databaseReference = FirebaseDatabase.getInstance().getReference("ALL USER");
        String uid = databaseReference.push().getKey();
        user u = new user(uid,N,E,P,UN,PS);
        databaseReference.push().setValue(u);

        NAME.setText("");
        EMAIL.setText("");
        PHONE.setText("");
        USERNAME.setText("");
        PASSWORD.setText("");

    }

    public void viewsdata(View view) {

        startActivity(new Intent(this,Main2Activity.class));
    }
}
