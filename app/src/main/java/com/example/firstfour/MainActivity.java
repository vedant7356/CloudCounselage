package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    CardView internships,industry,entre,about_us;
    MaterialButton todo,view_profile;
    ImageButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        internships=(CardView) findViewById(R.id.contributeCard);
        industry=(CardView) findViewById(R.id.industry_field);

        logout=(ImageButton)findViewById(R.id.logOutB);
        entre=(CardView) findViewById(R.id.gottoentre);
        about_us=(CardView) findViewById(R.id.about_us);
        todo=(MaterialButton)findViewById(R.id.todoB);
        view_profile=(MaterialButton)findViewById(R.id.editProfileB);

        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AboutUs.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        view_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewProfileSection.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });


        entre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,EntrepreneurshipDev.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ToDoTask.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });


        internships.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Internships.class));

                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        industry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WorkShop.class));

                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });


    }
}