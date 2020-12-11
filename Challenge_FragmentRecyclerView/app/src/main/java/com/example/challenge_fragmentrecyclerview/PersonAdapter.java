package com.example.challenge_fragmentrecyclerview;

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

    public PersonAdapter(Context context,ArrayList<Person> list){
        people=list;
        activity=(ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvOwner;
        TextView tvComamy;
        ImageView imgLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvComamy=itemView.findViewById(R.id.tvCompany);
            tvOwner=itemView.findViewById(R.id.tvOwner);
            imgLogo=itemView.findViewById(R.id.imgLogo);
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

        viewHolder.tvComamy.setText(people.get(i).getCompany());
        viewHolder.tvOwner.setText(people.get(i).getOwener());

        if(people.get(i).getLogo().equals("mercedes")){
            viewHolder.imgLogo.setImageResource(R.drawable.mercedes);
        }
        else if (people.get(i).getLogo().equals("volkswagen")){
            viewHolder.imgLogo.setImageResource(R.drawable.volkswagen);
        }
        else {
            viewHolder.imgLogo.setImageResource(R.drawable.nissan);
        }
    }


    @Override
    public int getItemCount() {
        return people.size();
    }
}
