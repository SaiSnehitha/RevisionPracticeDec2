package com.example.revisionpracticedec2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SideImagesAdapter extends BaseAdapter {
    ArrayList<Integer> data=new ArrayList<>();
    //to connect the list with the corresponding row_xml file
    LayoutInflater inflater;

    //constructor
    public SideImagesAdapter(Context context, ArrayList<Integer> data){
        this.data=data;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.side_row,null);
            holder=new ViewHolder();
            holder.placeImage=convertView.findViewById(R.id.lvSideImages);
            convertView.setTag(holder);
        }else
            holder=(ViewHolder) convertView.getTag();
        holder.placeImage.setImageResource(data.get(position));
        return convertView;
    }
    static class ViewHolder{
        private ImageView placeImage;
    }
}