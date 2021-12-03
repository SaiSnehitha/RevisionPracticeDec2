package com.example.revisionpracticedec2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {
    ArrayList<SelectedCart> data=new ArrayList<>();
   // static double pp;
    //to connect the list with the corresponding row_xml file
    LayoutInflater inflater;

    //constructor
    public CartAdapter(Context context, ArrayList<SelectedCart> data){
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
            convertView=inflater.inflate(R.layout.cart_row,null);
            holder=new ViewHolder();
            holder.placeName=convertView.findViewById(R.id.txtviewName3);
            holder.totalPrice=convertView.findViewById(R.id.txtviewPrice3);
            holder.persons=convertView.findViewById(R.id.txtviewPersons3);
            holder.delete=convertView.findViewById(R.id.btnDelete3);
            convertView.setTag(holder);
        }else
            holder=(ViewHolder) convertView.getTag();
        holder.placeName.setText(data.get(position).getName());
        holder.totalPrice.setText(String.valueOf(data.get(position).getPriceTotal()));
        holder.persons.setText(String.valueOf(data.get(position).getPerson()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // pp=MoreDetailsActivity.ttp-data.get(position).getPriceTotal();
                data.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
    static class ViewHolder{
        private TextView placeName;
        private TextView totalPrice;
        private TextView persons;
        private Button delete;
    }
}

