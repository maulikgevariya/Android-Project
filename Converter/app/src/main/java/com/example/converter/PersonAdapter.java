package com.example.converter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;
    ItemClicked activity;

    public interface ItemClicked{
        public void onItemClicked(int i);
    }

    public PersonAdapter(Context context, ArrayList<Person> list){
        people=list;
        activity=(ItemClicked) context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        ImageView ivConverter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tvName);
            ivConverter=itemView.findViewById(R.id.ivConverter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf((Person) v.getTag()));
                }
            });
        }
    }
    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(people.get(i));

        viewHolder.tvName.setText(people.get(i).getName());

        if(people.get(i).getLogo().equals("unit")){
            viewHolder.ivConverter.setImageResource(R.drawable.unit);
        }
        else if (people.get(i).getLogo().equals("money")){
            viewHolder.ivConverter.setImageResource(R.drawable.money);
        }
        else if (people.get(i).getLogo().equals("temperature")){
            viewHolder.ivConverter.setImageResource(R.drawable.temperture);
        }
        else if (people.get(i).getLogo().equals("speed")){
            viewHolder.ivConverter.setImageResource(R.drawable.speed);
        }
        else if (people.get(i).getLogo().equals("area")){
            viewHolder.ivConverter.setImageResource(R.drawable.area);
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
