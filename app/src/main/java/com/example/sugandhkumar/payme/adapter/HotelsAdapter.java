package com.example.sugandhkumar.payme.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sugandhkumar.payme.R;
import com.example.sugandhkumar.payme.model.Hotels;

import java.util.List;

/**
 * Created by sugandh kumar on 31-08-2017.
 */

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.HotelsHolder> {
    private Context hContext;
    private List<Hotels> hotelsList;
    private OnClickListener onClickListener;

    public HotelsAdapter(Context hContext, List<Hotels> hotelsList, OnClickListener onClickListener) {
        this.hContext = hContext;
        this.hotelsList = hotelsList;
        this.onClickListener = onClickListener;
    }

    @Override
    public HotelsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View iView = LayoutInflater.from(hContext).inflate(R.layout.content_hotels,parent,false);
        return  new HotelsHolder(iView);
    }

    @Override
    public void onBindViewHolder(HotelsHolder holder, int position) {
        final   Hotels hotel = hotelsList.get(position);
        holder.hotelName.setText("  "+hotel.gethName());
        holder.hotelCost.setText("€ "+hotel.getCost());
        holder.hotelRemarks.setText(hotel.gethRemarks());
        holder.hotelDistance.setText("   "+hotel.gethDistance()+" mi from Bangalore(city centre)");
        holder.hotelRatingPoint.setText(hotel.gethRatingPoint()+" ");

        Glide.with(hContext).load(hotel.getUrl()).into(holder.hotelImage);
    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }

    public class HotelsHolder extends RecyclerView.ViewHolder {
        private TextView hotelName;
        private TextView hotelCost;
        private ImageView hotelImage;
        private TextView hotelRemarks;
        private TextView hotelDistance;
        private TextView hotelRatingPoint;

        public HotelsHolder(final View itemView) {
            super(itemView);

            hotelName = (TextView) itemView.findViewById(R.id.tvHotelName);
            hotelCost = (TextView) itemView.findViewById(R.id.tvHotelCost);
            hotelImage = (ImageView) itemView.findViewById(R.id.ivHotelImage);
            hotelRemarks = (TextView) itemView.findViewById(R.id.remarks);
            hotelDistance = (TextView) itemView.findViewById(R.id.tvHotelDistance);
            hotelRatingPoint = (TextView) itemView.findViewById(R.id.rating_point);
            hotelName.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            hotelRemarks.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

            hotelImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(hotelsList.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnClickListener{
        void onClick(Hotels hotel);
    }
}
