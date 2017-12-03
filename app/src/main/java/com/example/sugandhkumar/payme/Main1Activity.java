package com.example.sugandhkumar.payme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main1Activity extends AppCompatActivity {
      ListView listView10;
    static String operator;
    String st[]={"Aircel","Airtel","BSNL","Idea","MTNL","MTS","Reliance CDMA","Reliance GSM","T24","Tata DOCOMO",
                 "Telenor","Videocon","Vodafone"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        listView10= (ListView) findViewById(R.id.listView10);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,st);
        listView10.setAdapter(arrayAdapter);
        listView10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//               operator=listView10.getSelectedItem().toString();
                        
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                 Toast.makeText(Main1Activity.this,"please Select any item from list",Toast.LENGTH_LONG).show();
            }
        });
    }
}
