package com.example.sugandhkumar.payme;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sugandh kumar on 20-07-2017.
 */

class MobileAdapter extends BaseExpandableListAdapter{
  private Context mContext;
    private HashMap<String,List<String>> ChildTitles;
    private List<String> HeaderTitles;

    public MobileAdapter(Context mContext, HashMap<String, List<String>> childTitles, List<String> headerTitles) {
        this.mContext = mContext;
        ChildTitles = childTitles;
        HeaderTitles = headerTitles;
    }

    @Override
    public int getGroupCount() {
        return HeaderTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ChildTitles.get(HeaderTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return HeaderTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return ChildTitles.get(HeaderTitles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String) this.getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mobile_header,null);
        }
        TextView txt = (TextView)convertView.findViewById(R.id.idTitle);
        txt.setTypeface(Typeface.createFromAsset(mContext.getAssets(),"Clockopia.ttf"));
        txt.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String) this.getChild(groupPosition,childPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mobile_childitems,null);
        }
        TextView txt = (TextView) convertView.findViewById(R.id.idChild);
        txt.setTypeface(Typeface.createFromAsset(mContext.getAssets(),"Pangram-Regular.otf"));
        txt.setText(title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
