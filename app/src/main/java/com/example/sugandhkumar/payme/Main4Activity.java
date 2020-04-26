package com.example.sugandhkumar.payme;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.sugandhkumar.payme.DataProvider.getInfo;

public class Main4Activity extends AppCompatActivity {
    HashMap<String,List<String>>  myHeader;
    List<String> myChild;
    ExpandableListView expandableListView;
    MobileAdapter myAdapter;
    private ImageView imgBeauty;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imgBeauty = (ImageView) findViewById(R.id.img_beauty);
        expandableListView = (ExpandableListView) findViewById(R.id.listView11);
        myHeader = getInfo();
        myChild = new ArrayList<String>(myHeader.keySet());
        myAdapter = new MobileAdapter(this,myHeader,myChild);
        expandableListView.setAdapter(myAdapter);

    }


}
