package com.example.firstfour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class viewcourseadapter extends RecyclerView.Adapter<viewcourseadapter.ViewHolder>{

    private ArrayList<MoreCourses> coursesArrayList;
    private Context context;

    public viewcourseadapter(ArrayList<MoreCourses> coursesArrayList, Context context) {
        this.coursesArrayList = coursesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.display_courses, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoreCourses courses = coursesArrayList.get(position);
        holder.Name.setText(courses.getName());
        holder.Rating.setText(courses.getRating());
        holder.Date.setText(courses.getDate());
        Picasso.get()
                .load(courses.getImage_url())
                .fit()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return coursesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView Rating;
        TextView Date;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.idTVCourseName);
            Rating = itemView.findViewById(R.id.idTVCourseRating);
            Date = itemView.findViewById(R.id.date_course);
            imageView=itemView.findViewById(R.id.idIVCourseImage);
        }
    }
}
