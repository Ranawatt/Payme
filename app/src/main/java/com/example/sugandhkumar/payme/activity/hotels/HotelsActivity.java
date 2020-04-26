package com.example.sugandhkumar.payme.activity.hotels;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import com.example.sugandhkumar.payme.Main2Activity;
import com.example.sugandhkumar.payme.R;
import com.example.sugandhkumar.payme.adapter.HotelsAdapter;
import com.example.sugandhkumar.payme.model.Hotels;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HotelsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private DatabaseReference mDatabase;
    private ProgressDialog progressDialog;
    private List<Hotels> hotelsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_bangalore_hotel);
        getSupportActionBar().setTitle("Bengaluru Hotels");
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        hotelsList = new ArrayList<>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        mDatabase = FirebaseDatabase.getInstance().getReference("hotel");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                progressDialog.dismiss();
                // iterating value from server
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Hotels hotel = postSnapshot.getValue(Hotels.class);
                    hotelsList.add(hotel);
                }

                adapter = new HotelsAdapter(getApplicationContext(),hotelsList,onClickListener);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });

    }


    private HotelsAdapter.OnClickListener onClickListener = new HotelsAdapter.OnClickListener() {
        @Override
        public void onClick(Hotels hotel) {
            final Intent hIntent = new Intent(HotelsActivity.this,Main2Activity.class);
            hIntent.putExtra("hName",hotel.gethName());
            startActivity(hIntent);
        }
    };
}
