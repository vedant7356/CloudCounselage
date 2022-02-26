package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class SoftSkillDev extends AppCompatActivity {
    CardView quiz, practice, resources;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_skill_dev);

        quiz = (CardView) findViewById(R.id.card_quiz);
        practice = (CardView) findViewById(R.id.card_practice);
        resources = (CardView) findViewById(R.id.card_resources);

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        SoftSkillDev.this, QuizActivity.class
                ));
            }
        });

        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        SoftSkillDev.this, PracticeActivity.class
                ));
            }
        });

        resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        SoftSkillDev.this, ResourcesActivity.class
                ));
            }
        });

    }
}