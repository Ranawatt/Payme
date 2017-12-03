package com.example.sugandhkumar.payme;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sugandh kumar on 21-07-2017.
 */

public class ElectronicsAdapter extends RecyclerView.Adapter<ElectronicsAdapter.ElectronicsHolder>{
    private Context eContext;
    private List<Electronics> itemsList;

    public ElectronicsAdapter(Context eContext, List<Electronics> itemsList) {
        this.eContext = eContext;
        this.itemsList = itemsList;
    }

    @Override
    public ElectronicsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View eView = LayoutInflater.from(eContext).inflate(R.layout.content_electronics,parent,false);
        return new ElectronicsHolder(eView);
    }

    @Override
    public void onBindViewHolder(ElectronicsHolder holder, int position) {
       final Electronics electronics = itemsList.get(position);
        holder.eName.setText(electronics.getkName());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public class ElectronicsHolder extends RecyclerView.ViewHolder {
        private TextView eName;
        public ElectronicsHolder(View itemView) {
            super(itemView);
            eName = (TextView) itemView.findViewById(R.id.tvEname);
            eName.setTypeface(Typeface.MONOSPACE);
        }
    }
}
