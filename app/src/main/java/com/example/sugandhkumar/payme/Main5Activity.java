package com.example.sugandhkumar.payme;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    private RecyclerView eRecyclerView;
    private RecyclerView.Adapter eAdapter;
    private DatabaseReference eDatabase;
    private List<Electronics> itemList;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        eRecyclerView = (RecyclerView) findViewById(R.id.rvElectronics);
        eRecyclerView.setHasFixedSize(true);
        eRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();
        eDatabase = FirebaseDatabase.getInstance().getReference("electronics");
        eDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                for (DataSnapshot objectSnapshot : dataSnapshot.getChildren()){
                    Electronics electronics = objectSnapshot.getValue(Electronics.class);
                    itemList.add(electronics);
                }
                eAdapter = new ElectronicsAdapter(getApplicationContext(),itemList);
                eRecyclerView.setAdapter(eAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Oops,You are not Connected",Toast.LENGTH_LONG).show();
            }
        });
    }
}
