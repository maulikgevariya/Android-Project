package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Personadapter extends RecyclerView.Adapter<Personadapter.ViewHolder> {

    private ArrayList<Person> people;
    ItemClick activity;

    public interface ItemClick{
        void onItemClick(int i);
    }

    public Personadapter(Context context, ArrayList<Person> list){
        people=list;
        activity=(ItemClick) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivpre;
        TextView tvname,tvsurname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname=itemView.findViewById(R.id.tvname);
            tvsurname=itemView.findViewById(R.id.tvsurname);
            ivpre=itemView.findViewById(R.id.ivpre);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClick(people.indexOf((Person) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public Personadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Personadapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(people.get(i));

        viewHolder.tvname.setText(people.get(i).getName());
        viewHolder.tvsurname.setText(people.get(i).getSurname());

        if(people.get(i).getPreference().equals("bus")){
            viewHolder.ivpre.setImageResource(R.drawable.bus);
        }
        else{
            viewHolder.ivpre.setImageResource(R.drawable.plan);
        }

    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
