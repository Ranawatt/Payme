package com.example.sugandhkumar.payme.adapter.flipkart;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sugandhkumar.payme.R;
import com.example.sugandhkumar.payme.model.flipkartinfo.ProductInfoList;

import java.util.ArrayList;

/**
 * Created by sugandh kumar on 18-02-2018.
 */

public class FoodNutritionAdapter extends RecyclerView.Adapter<FoodNutritionAdapter.FoodNutritionHolder> {
    private Context fContext;
    private ArrayList<ProductInfoList> mLists = new ArrayList<>();
    private OnClickListener onClickListener;

    public FoodNutritionAdapter(Context fContext, ArrayList<ProductInfoList> mLists, OnClickListener onClickListener) {
        this.fContext = fContext;
        this.mLists = mLists;
        this.onClickListener = onClickListener;
    }

    @Override
    public FoodNutritionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View fView = LayoutInflater.from(fContext).inflate(R.layout.content_television,parent,false);
        return new FoodNutritionHolder(fView);
    }

    @Override
    public void onBindViewHolder(FoodNutritionHolder holder, int position) {
        ProductInfoList prodLists = mLists.get(position);

        holder.teleSeter.setText(prodLists.getProductBaseInfo().getProductIdentifier().getProductId());
        holder.teleSeter2.setText(prodLists.getProductBaseInfo().getProductAttributes().getTitle());
        Glide.with(fContext).load(prodLists.getProductBaseInfo().getProductAttributes().getImageUrls().getUnknown()).into(holder.teleImage);
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class FoodNutritionHolder extends RecyclerView.ViewHolder {
        private TextView teleSeter, teleSeter2;
        private ImageView teleImage;
        public FoodNutritionHolder(View itemView) {
            super(itemView);
            teleSeter = itemView.findViewById(R.id.teleSeter);
            teleSeter2 = itemView.findViewById(R.id.teleSeter2);
            teleImage = itemView.findViewById(R.id.teleImage);
        }
    }

    public interface OnClickListener {
//        void onToggleClick(DeviceRaw iDeviceRaw);

//        void onClick(DeviceRaw iDeviceRaw);
    }
}
