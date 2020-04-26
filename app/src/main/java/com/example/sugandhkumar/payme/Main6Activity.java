package com.example.sugandhkumar.payme;

import android.content.Intent;
import android.content.res.Resources;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

import com.example.sugandhkumar.payme.adapter.HotelsAdapter;
import com.example.sugandhkumar.payme.adapter.KitchenAdapter;
import com.example.sugandhkumar.payme.model.Hotels;
import com.example.sugandhkumar.payme.model.Kitchen;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main6Activity extends AppCompatActivity {

    private RecyclerView recyclerMen, recyclerMen2;
    private RecyclerView.Adapter recyclerAdapter;
    private DatabaseReference mDatabase, mDatabaseHotels;
    private List<Hotels> hotelLists;
    private List<Kitchen> kitchenLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        setCustomActionBar();
        initView();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(R.color.colorAccent);
        recyclerMen.setHasFixedSize(true);
        recyclerMen2.setHasFixedSize(true);
        recyclerMen2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerMen2.addItemDecoration(new MovieSongs.GridSpacingItemDecoration(2, dpToPx(5), true));
        recyclerMen2.setItemAnimator(new DefaultItemAnimator());
        recyclerMen.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        hotelLists = new ArrayList<>();
        kitchenLists = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference("kitchen");
        mDatabaseHotels = FirebaseDatabase.getInstance().getReference("hotel");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                    Kitchen kitchen = postSnapShot.getValue(Kitchen.class);
                    kitchenLists.add(kitchen);
                }
                recyclerAdapter = new KitchenAdapter(getApplicationContext(), kitchenLists);
                recyclerMen2.setAdapter(recyclerAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabaseHotels.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                    Hotels hotel = postSnapShot.getValue(Hotels.class);
                    hotelLists.add(hotel);
                }
                recyclerAdapter = new HotelsAdapter(getApplicationContext(),hotelLists,onClickListener);
                recyclerMen.setAdapter(recyclerAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void setCustomActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setTitle("Hot Deals");

    }

    private void initView() {
        recyclerMen = (RecyclerView) findViewById(R.id.recycler_men);
        recyclerMen2 = (RecyclerView) findViewById(R.id.recycler_men1);
    }

    private HotelsAdapter.OnClickListener onClickListener = new HotelsAdapter.OnClickListener() {
        @Override
        public void onClick(Hotels hotel) {
            final Intent hIntent = new Intent(Main6Activity.this,Main2Activity.class);
            hIntent.putExtra("hName",hotel.gethName());
            startActivity(hIntent);
        }
    };
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
