package com.example.sugandhkumar.payme;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.widget.Toast;

import com.example.sugandhkumar.payme.adapter.KitchenAdapter;
import com.example.sugandhkumar.payme.model.Kitchen;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class KitchenHome extends AppCompatActivity {
    private RecyclerView kitchenView;
    private RecyclerView.Adapter kAdapter;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    private List<Kitchen> kitchenItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_home);

        kitchenView = (RecyclerView) findViewById(R.id.kHomeView);
        kitchenView.setHasFixedSize(true);
        kitchenView.setLayoutManager(new GridLayoutManager(this, 2));
        kitchenView.addItemDecoration(new MovieSongs.GridSpacingItemDecoration(2, dpToPx(5), true));
        kitchenView.setItemAnimator(new DefaultItemAnimator());

        kitchenItems = new ArrayList<>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait....");
        progressDialog.show();

        databaseReference = FirebaseDatabase.getInstance().getReference("kitchen");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                    Kitchen kitchen = postSnapShot.getValue(Kitchen.class);
                    kitchenItems.add(kitchen);
                }

                kAdapter = new KitchenAdapter(getApplicationContext(), kitchenItems);
                kitchenView.setAdapter(kAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Network issue..", Toast.LENGTH_LONG).show();
            }
        });
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
