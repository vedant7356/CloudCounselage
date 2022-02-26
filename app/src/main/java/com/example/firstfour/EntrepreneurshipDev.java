package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EntrepreneurshipDev extends AppCompatActivity implements View.OnClickListener {

    public CardView card1, card2, card3, card4,card5 , card6,card7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrepreneurship_dev);

        card1 = (CardView) findViewById(R.id.a1);
        card2 = (CardView) findViewById(R.id.a2);
        card3 = (CardView) findViewById(R.id.a3);
        card4 = (CardView) findViewById(R.id.a4);
        card5 = (CardView) findViewById(R.id.a5);
        card6 = (CardView) findViewById(R.id.a6);
        card7=(CardView)findViewById(R.id.skill_dev);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch(view.getId())
        {
            case R.id.a1 :
                i = new Intent(this,ActivityOne.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;

            case R.id.a2 :
                i = new Intent(this,ActivityTwo.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.a3 :
                i = new Intent(this,ActivityThree.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.a4 :
                i = new Intent(this,ActivityFour.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.a5 :
                i = new Intent(this,ActivityFive.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.a6 :
                i = new Intent(this,ActivitySix.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.skill_dev:
                i = new Intent(this,SoftSkillDev.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;


        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}