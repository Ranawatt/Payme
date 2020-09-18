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

public class MensFootwearAdapter extends RecyclerView.Adapter<MensFootwearAdapter.MensFootwearHolder> {
    private Context mContext;
    private ArrayList<ProductInfoList> mLists = new ArrayList<>();
    private OnClickListener onClickListener;

    public MensFootwearAdapter(Context mContext, ArrayList<ProductInfoList> mLists, OnClickListener onClickListener) {
        this.mContext = mContext;
        this.mLists = mLists;
        this.onClickListener = onClickListener;
    }

    @Override
    public MensFootwearHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(mContext).inflate(R.layout.content_television,parent,false);
        return new MensFootwearHolder(mView);
    }

    @Override
    public void onBindViewHolder(MensFootwearHolder holder, int position) {
        ProductInfoList prodLists = mLists.get(position);

        holder.teleSeter.setText(prodLists.getProductBaseInfo().getProductIdentifier().getProductId());
        holder.teleSeter2.setText(prodLists.getProductBaseInfo().getProductAttributes().getTitle());
        Glide.with(mContext).load(prodLists.getProductBaseInfo().getProductAttributes().getImageUrls().getUnknown()).into(holder.teleImage);
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class MensFootwearHolder extends RecyclerView.ViewHolder {
        private TextView teleSeter, teleSeter2;
        private ImageView teleImage;
        public MensFootwearHolder(View itemView) {
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
