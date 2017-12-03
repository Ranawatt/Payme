package com.example.sugandhkumar.payme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.sugandhkumar.payme.R.id.listView13;

public class Main6Activity extends AppCompatActivity {
    ListView lvProducts;
    String st[] = {"Accessories","Bags & Luggage","Clothing","EyeWear","FootWear","Grooming & Personal Care","Watches"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        lvProducts= (ListView) findViewById(listView13);
        lvProducts.addHeaderView(getLayoutInflater().inflate(R.layout.product_list_header, lvProducts, false));
        ArrayAdapter<String> array2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, st);
        lvProducts.setAdapter(array2);
        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main6Activity.this,st[position],Toast.LENGTH_LONG).show();
            }
        });
    }
}
