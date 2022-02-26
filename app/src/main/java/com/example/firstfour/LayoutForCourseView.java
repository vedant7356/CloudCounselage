package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class LayoutForCourseView extends AppCompatActivity {
    TextView tv1;
    RatingBar mRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_for_course_view);

        tv1=(TextView) findViewById(R.id.go_to_review);
        mRatingBar=(RatingBar)findViewById(R.id.this_is_rating);


        mRatingBar.setRating(8);

        String url="https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/Y2Mate.is%20-%20(NEW%20Course%20Trailer)%20Web%20Design%20Becoming%20a%20Professional-tcbh0yqBgns-1080p-1644604251925.mp4?alt=media&token=34417005-13eb-4a9a-a998-c76a0a09c022";
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LayoutForCourseView.this,LayoutForReviews.class));
            }
        });

        SimpleExoPlayer simpleExoPlayer=new SimpleExoPlayer.Builder(this).build();

        PlayerView playerView=findViewById(R.id.exoplaya);

        playerView.setPlayer(simpleExoPlayer);
        MediaItem mediaItem=MediaItem.fromUri(url);
        simpleExoPlayer.addMediaItem(mediaItem);

        simpleExoPlayer.prepare();


    }
}