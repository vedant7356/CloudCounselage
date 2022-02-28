package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class AboutUs extends AppCompatActivity {

    String url1 = "https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/abtimg1.jpeg?alt=media&token=171dd4f8-de5e-4df0-a41d-03b79cdbd18a";
    String url2 = "https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/abtimg2.png?alt=media&token=4d3a6e83-c33f-4c23-b19e-86208f725892";
    String url3 = "https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/abtimg3.jpeg?alt=media&token=4b86cabf-5141-428c-be9e-36209fcee86c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        SliderView sliderView = findViewById(R.id.slider_show_unemployment);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));


        SliderAdapter adapterv = new SliderAdapter(this, sliderDataArrayList);

        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);


        sliderView.setSliderAdapter(adapterv);


        sliderView.setScrollTimeInSec(3);

        sliderView.setAutoCycle(true);

        sliderView.startAutoCycle();
    }
}