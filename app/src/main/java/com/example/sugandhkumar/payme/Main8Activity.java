package com.example.sugandhkumar.payme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {
    ListView listView15;
    String  st[]={"Apparels","Baby Care & Maternity","Baby & Kids Room Essentials","FootWear",
                  "Kids Accessories","Prams,Strollers & Walkers","School Supplies"," Toys  & Games"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        listView15= (ListView) findViewById(R.id.listView15);
        ArrayAdapter<String> array= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,st);
        listView15.setAdapter(array);
        listView15.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main8Activity.this,st[position],Toast.LENGTH_LONG).show();
            }
        });
    }
}
