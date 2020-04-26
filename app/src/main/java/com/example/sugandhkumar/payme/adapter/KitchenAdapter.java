package com.example.sugandhkumar.payme.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sugandhkumar.payme.R;
import com.example.sugandhkumar.payme.model.Kitchen;

import java.util.List;

/**
 * Created by sugandh kumar on 31-08-2017.
 */

public class KitchenAdapter extends RecyclerView.Adapter<KitchenAdapter.KitchenHolder> {
    private Context kContext;
    private List<Kitchen> kitchenItems;

    public KitchenAdapter(Context kContext, List<Kitchen> kitchenItems) {
        this.kContext = kContext;
        this.kitchenItems = kitchenItems;
    }

    @Override
    public KitchenHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View kView = LayoutInflater.from(kContext).inflate(R.layout.content_kitchen,parent,false);
        return new KitchenHolder(kView);
    }

    @Override
    public void onBindViewHolder(KitchenHolder holder, int position) {
        final Kitchen kitchen = kitchenItems.get(position);
        holder.itemName.setText(kitchen.getkName());
        holder.itemCost.setText("€ "+kitchen.getkCost());
        Glide.with(kContext).load(kitchen.getkUrl()).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return kitchenItems.size();
    }

    public class KitchenHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView itemCost;
        ImageView itemImage;
        RatingBar itemRating;
        TextView tvReview;
        public KitchenHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.tvItemName);
            itemCost = (TextView) itemView.findViewById(R.id.tvItemCost);
            itemImage = (ImageView) itemView.findViewById(R.id.ivKitchenImage);
            itemRating = (RatingBar) itemView.findViewById(R.id.rating_bar);
            tvReview = (TextView) itemView.findViewById(R.id.tvReview);

        }
    }
}
