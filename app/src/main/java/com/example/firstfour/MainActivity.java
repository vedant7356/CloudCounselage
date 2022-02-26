package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    CardView internships,industry,entre;
    MaterialButton todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        internships=(CardView) findViewById(R.id.contributeCard);
        industry=(CardView) findViewById(R.id.industry_field);

        entre=(CardView) findViewById(R.id.gottoentre);
        todo=(MaterialButton)findViewById(R.id.todoB);


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