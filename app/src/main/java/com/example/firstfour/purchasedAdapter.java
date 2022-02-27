package com.example.firstfour;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class purchasedAdapter extends RecyclerView.Adapter<purchasedAdapter.ViewHolder>{

    private ArrayList<nav_layouts> coursesArrayList;
    private Context context;

    public purchasedAdapter(ArrayList<nav_layouts> coursesArrayList, Context context) {
        this.coursesArrayList = coursesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new purchasedAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.purchasedlayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        nav_layouts courses = coursesArrayList.get(position);
        holder.Name.setText(courses.getTitle());
        holder.Rating.setText(courses.getRating());
        holder.Author.setText(courses.getAuthor());
        Picasso.get()
                .load(courses.getImage_url())
                .fit()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView Rating;
        TextView Author;
        ImageView imageView;
        Button go_to_main;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.title_purchase);
            Rating = itemView.findViewById(R.id.rating_purchase);
            Author = itemView.findViewById(R.id.author_purchase);
            imageView=itemView.findViewById(R.id.person_pic_purchase);
            go_to_main=itemView.findViewById(R.id.buynow_ac_purchase);


            go_to_main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,CourseMainMenu.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
