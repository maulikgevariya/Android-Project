package com.example.customlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    private final Context context;
    private final ArrayList<Product> values;


    public ProductAdapter(Context context, ArrayList<Product> values) {
        super(context,R.layout.row_layout,values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.row_layout,parent,false);

        TextView tvProduct,tvPrice,tvDescription;

        tvProduct=(TextView) view.findViewById(R.id.tvProduct);
        tvPrice=(TextView) view.findViewById(R.id.tvPrice);
        tvDescription=(TextView) view.findViewById(R.id.tvDescription);

        ImageView ivProduct=(ImageView) view.findViewById(R.id.ivProduct);
        ImageView ivSale = (ImageView) view.findViewById(R.id.ivSale);

        tvProduct.setText(values.get(position).getTitle());
        tvPrice.setText("Rs."+values.get(position).getPrice());
        tvDescription.setText(values.get(position).getDescription());

        if(values.get(position).isSale()){
            ivSale.setImageResource(R.mipmap.sale);
        }
        else {
            ivSale.setImageResource(R.mipmap.best_price);
        }

        if(values.get(position).getType().equals("Laptop")){
            ivProduct.setImageResource(R.mipmap.laptop);
        }
        else if (values.get(position).getType().equals("Memory")){
            ivProduct.setImageResource(R.mipmap.pendrive);
        }
        else if (values.get(position).getType().equals("Screen")){
            ivProduct.setImageResource(R.mipmap.screen);
        }
        else {
            ivProduct.setImageResource(R.mipmap.hard_drive);
        }

        return view;
    }
}
