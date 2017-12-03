package com.example.sugandhkumar.payme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.sugandhkumar.payme.DataProvider.getInfo;

public class Main4Activity extends AppCompatActivity {
    HashMap<String,List<String>>  myHeader;
    List<String> myChild;
    ExpandableListView expandableListView;
    MobileAdapter myAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        expandableListView = (ExpandableListView) findViewById(R.id.listView11);
        myHeader = getInfo();
        myChild = new ArrayList<String>(myHeader.keySet());
        myAdapter = new MobileAdapter(this,myHeader,myChild);
        expandableListView.setAdapter(myAdapter);

    }


}
