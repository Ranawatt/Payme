package com.example.sugandhkumar.payme.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sugandhkumar.payme.R;
import com.example.sugandhkumar.payme.model.Navmenu;

import java.util.List;

/**
 * Created by sugandh kumar on 31-12-2017.
 */

public class NavMenuAdapter extends RecyclerView.Adapter<NavMenuAdapter.NavMenuHolder> {

    private Context navContext;
    private List<Navmenu> navmenuList;
    private OnClickListener onClickListener;

    public NavMenuAdapter(Context navContext, List<Navmenu> navmenuList) {
        this.navContext = navContext;
        this.navmenuList = navmenuList;
    }

    public NavMenuAdapter(Context navContext, List<Navmenu> navmenuList, OnClickListener onClickListener) {
        this.navContext = navContext;
        this.navmenuList = navmenuList;
        this.onClickListener = onClickListener;
    }

    @Override
    public NavMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View iView = LayoutInflater.from(navContext).inflate(R.layout.content_navmenu,parent,false);
        return  new NavMenuHolder(iView);
    }

    @Override
    public void onBindViewHolder(NavMenuHolder holder, int position) {

        final  Navmenu navmenu = navmenuList.get(position);
        holder.navMenuName.setText(navmenu.getNavName());
        Glide.with(navContext).load(navmenu.getNavUrl()).into(holder.navMenuImage);
    }

    @Override
    public int getItemCount() {
        return navmenuList.size();
    }

    public class NavMenuHolder extends RecyclerView.ViewHolder {
        private TextView navMenuName;
        private ImageView navMenuImage;
        public NavMenuHolder(View itemView) {
            super(itemView);

            navMenuName = (TextView) itemView.findViewById(R.id.txt_navmenu);
            navMenuImage = (ImageView) itemView.findViewById(R.id.img_navmenu);

            navMenuImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(navmenuList.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnClickListener{
        void onClick(Navmenu navmenu);
    }
}
