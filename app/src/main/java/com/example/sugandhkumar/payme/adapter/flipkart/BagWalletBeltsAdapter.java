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

public class BagWalletBeltsAdapter extends RecyclerView.Adapter<BagWalletBeltsAdapter.BagWalletBeltsHolder> {

    private Context bContext;
    private ArrayList<ProductInfoList> mLists = new ArrayList<>();
    private OnClickListener onClickListener;

    public BagWalletBeltsAdapter(Context bContext, ArrayList<ProductInfoList> mLists, OnClickListener onClickListener) {
        this.bContext = bContext;
        this.mLists = mLists;
        this.onClickListener = onClickListener;
    }

    @Override
    public BagWalletBeltsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View bView = LayoutInflater.from(bContext).inflate(R.layout.content_television,parent,false);
        return new BagWalletBeltsHolder(bView);
    }

    @Override
    public void onBindViewHolder(BagWalletBeltsHolder holder, int position) {
        ProductInfoList prodLists = mLists.get(position);

        holder.teleSeter.setText(prodLists.getProductBaseInfo().getProductIdentifier().getProductId());
        holder.teleSeter2.setText(prodLists.getProductBaseInfo().getProductAttributes().getTitle());
        Glide.with(bContext).load(prodLists.getProductBaseInfo().getProductAttributes().getImageUrls().getUnknown()).into(holder.teleImage);
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class BagWalletBeltsHolder extends RecyclerView.ViewHolder {
        private TextView teleSeter, teleSeter2;
        private ImageView teleImage;
        public BagWalletBeltsHolder(View itemView) {
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
