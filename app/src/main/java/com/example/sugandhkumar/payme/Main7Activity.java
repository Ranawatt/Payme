package com.example.sugandhkumar.payme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {

//    private RecyclerView wRecyclerView;
//    private RecyclerView.Adapter wAdapter;
//    private DatabaseReference wDatabase;
    ListView listView14;
    String st[]={"Bags & Wallets","Designer Wear","Ethnic Wear","FootWear","Jwellery","Lingerie & SleepWear",
            "Watches","Western Wear","Wholesale"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        listView14= (ListView) findViewById(R.id.listView14);
        ArrayAdapter<String> array= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,st);
        listView14.setAdapter(array);
        listView14.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main7Activity.this,st[position],Toast.LENGTH_LONG).show();
            }
        });
    }
}
