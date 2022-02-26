package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class WorkShop extends AppCompatActivity {
    ImageButton i1;

    Button workshop;

    String url1 = "https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/SliderImages%2FWorkshopSlider%2Fimg1.jpeg?alt=media&token=8233a7b7-d279-4320-a982-2596218b3fd7";
    String url2 = "https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/SliderImages%2FWorkshopSlider%2Fimg2.jpeg?alt=media&token=0b0a66df-4d73-4a8a-a276-5b9d2334812a";
    String url3 = "https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/SliderImages%2FWorkshopSlider%2Fimg3.webp?alt=media&token=2ba8281e-166c-4a77-b6e2-8e76969f4604";

    String url4 = "https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/SliderImages%2FWorkshopSlider%2Fimg1.jpeg?alt=media&token=8233a7b7-d279-4320-a982-2596218b3fd7";
    String url5 = "https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/SliderImages%2FWorkshopSlider%2Fimg2.jpeg?alt=media&token=0b0a66df-4d73-4a8a-a276-5b9d2334812a";
    String url6 = "https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/SliderImages%2FWorkshopSlider%2Fimg3.webp?alt=media&token=2ba8281e-166c-4a77-b6e2-8e76969f4604";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_shop);
// we are creating array list for storing our image urls.
        String url="https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/Y2Mate.is%20-%20(NEW%20Course%20Trailer)%20Web%20Design%20Becoming%20a%20Professional-tcbh0yqBgns-1080p-1644604251925.mp4?alt=media&token=34417005-13eb-4a9a-a998-c76a0a09c022";
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        ArrayList<SliderData> sliderDataArrayListv = new ArrayList<>();

        i1 = findViewById(R.id.travel);
        workshop=findViewById(R.id.reg_here_wrk);


        workshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),WorkshopRegisteration.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii =  new Intent(WorkShop.this,IndustrialVisit.class);
                startActivity(ii);
            }
        });
        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        SliderView sliderViewtwo = findViewById(R.id.slider_others);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));


        sliderDataArrayListv.add(new SliderData(url3));
        sliderDataArrayListv.add(new SliderData(url2));
        sliderDataArrayListv.add(new SliderData(url1));


        SliderAdapter adapterv = new SliderAdapter(this, sliderDataArrayListv);

        sliderViewtwo.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);


        sliderViewtwo.setSliderAdapter(adapterv);


        sliderViewtwo.setScrollTimeInSec(3);

        sliderViewtwo.setAutoCycle(true);

        sliderViewtwo.startAutoCycle();

        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);


        sliderView.setSliderAdapter(adapter);


        sliderView.setScrollTimeInSec(3);

        sliderView.setAutoCycle(true);

        sliderView.startAutoCycle();

        SimpleExoPlayer simpleExoPlayer=new SimpleExoPlayer.Builder(this).build();

        PlayerView playerView=findViewById(R.id.exoplaya_web);

        playerView.setPlayer(simpleExoPlayer);
        MediaItem mediaItem=MediaItem.fromUri(url);
        simpleExoPlayer.addMediaItem(mediaItem);

        simpleExoPlayer.prepare();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}