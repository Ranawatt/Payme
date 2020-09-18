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

public class KidsFootwearAdapter extends RecyclerView.Adapter<KidsFootwearAdapter.KidsFootwearHolder> {
    private Context kContext;
    private ArrayList<ProductInfoList> mLists = new ArrayList<>();
    private OnClickListener onClickListener;

    public KidsFootwearAdapter(Context kContext, ArrayList<ProductInfoList> mLists, OnClickListener onClickListener) {
        this.kContext = kContext;
        this.mLists = mLists;
        this.onClickListener = onClickListener;
    }

    @Override
    public KidsFootwearHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View kView = LayoutInflater.from(kContext).inflate(R.layout.content_television, parent,false);
        return new KidsFootwearHolder(kView);
    }

    @Override
    public void onBindViewHolder(KidsFootwearHolder holder, int position) {
        ProductInfoList prodLists = mLists.get(position);

        holder.teleSeter.setText(prodLists.getProductBaseInfo().getProductIdentifier().getProductId());
        holder.teleSeter2.setText(prodLists.getProductBaseInfo().getProductAttributes().getTitle());
        Glide.with(kContext).load(prodLists.getProductBaseInfo().getProductAttributes().getImageUrls().getUnknown()).into(holder.teleImage);
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class KidsFootwearHolder extends RecyclerView.ViewHolder {
        private TextView teleSeter, teleSeter2;
        private ImageView teleImage;
        public KidsFootwearHolder(View itemView) {
            super(itemView);
            teleSeter = itemView.findViewById(R.id.teleSeter);
            teleSeter2 = itemView.findViewById(R.id.teleSeter2);
            teleImage = itemView.findViewById(R.id.teleImage);
        }
    }
    public interface OnClickListener {

    }
}
