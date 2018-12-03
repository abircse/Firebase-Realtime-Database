package com.studioabir.firebasedatabase.firebasedatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.studioabir.firebasedatabase.firebasedatabase.model.user;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {


    ListView lv;
    DatabaseReference databaseReference;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = findViewById(R.id.mylist);
        arrayList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("ALL USER");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    user u = snapshot.getValue(user.class);
                    arrayList.add("\n"+"Name: "+u.getName()+"\n"+"Email: "+u.getEmail()+"\n"+"Phone: "+u.getPhone()+"\n");

                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_list_item_1,arrayList);
                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
