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
 * Created by sugandh kumar on 14-02-2018.
 */

public class TelevisionAdapter extends RecyclerView.Adapter<TelevisionAdapter.TelevisionHolder> {
    private Context tContext;
    private ArrayList<ProductInfoList> mLists = new ArrayList<>();
    private OnClickListener onClickListener;



    public TelevisionAdapter(Context tContext, ArrayList<ProductInfoList> mLists, OnClickListener onClickListener) {
        this.tContext = tContext;
        this.mLists = mLists;
        this.onClickListener = onClickListener;
    }

    @Override
    public TelevisionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tView = LayoutInflater.from(tContext).inflate(R.layout.content_television,parent,false);
        return new TelevisionHolder(tView);
    }

    @Override
    public void onBindViewHolder(TelevisionHolder holder, int position) {

        ProductInfoList prodLists = mLists.get(position);

        holder.teleSeter.setText(prodLists.getProductBaseInfo().getProductIdentifier().getProductId());
        holder.teleSeter2.setText(prodLists.getProductBaseInfo().getProductAttributes().getTitle());
        Glide.with(tContext).load(prodLists.getProductBaseInfo().getProductAttributes().getImageUrls().getUnknown()).into(holder.teleImage);
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class TelevisionHolder extends RecyclerView.ViewHolder {
        private TextView teleSeter, teleSeter2;
        private ImageView teleImage;
        public TelevisionHolder(View itemView) {
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
