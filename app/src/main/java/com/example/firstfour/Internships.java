package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Internships extends AppCompatActivity {
    CardView cd1;
    TextView explore_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internships);

        cd1=(CardView) findViewById(R.id.web_dev);
        explore_more=(TextView)findViewById(R.id.explore_more);

        explore_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Internships.this,ExploreMoreCourses.class));
            }
        });

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Internships.this,LayoutForCourseView.class));
            }
        });
    }
}