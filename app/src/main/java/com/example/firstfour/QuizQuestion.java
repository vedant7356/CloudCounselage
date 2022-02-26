package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizQuestion extends AppCompatActivity {

    CardView ans1, ans2, ans3;
    TextView tv_ans1, tv_ans3;
    Button finish_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        tv_ans1 =  findViewById(R.id.tva);
        tv_ans3 = findViewById(R.id.tvc);

        ans1 = findViewById(R.id.answera);
        ans2 = findViewById(R.id.answerb);
        ans3 = findViewById(R.id.answerc);

        finish_button = findViewById(R.id.finish_button);

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setCardBackgroundColor(Color.parseColor("#b00020"));
                tv_ans1.setTextColor(Color.parseColor("#ffffff"));
                ans2.setEnabled(false); ans3.setEnabled(false);
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans2.setCardBackgroundColor(Color.parseColor("#03dac6"));
                ans1.setEnabled(false); ans3.setEnabled(false);
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans3.setCardBackgroundColor(Color.parseColor("#b00020"));
                tv_ans3.setTextColor(Color.parseColor("#ffffff"));
                ans1.setEnabled(false); ans2.setEnabled(false);
            }
        });

        finish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
