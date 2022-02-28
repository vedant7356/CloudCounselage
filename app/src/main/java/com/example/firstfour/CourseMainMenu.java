package com.example.firstfour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.techatmosphere.expandablenavigation.model.ChildModel;
import com.techatmosphere.expandablenavigation.model.HeaderModel;
import com.techatmosphere.expandablenavigation.view.ExpandableNavigationListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseMainMenu extends AppCompatActivity{

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    ExpandableNavigationListView expandableNavigationListView;
    DrawerLayout drawerLayout;
    String url="https://firebasestorage.googleapis.com/v0/b/cloudcounselage-a4e03.appspot.com/o/Y2Mate.is%20-%20(NEW%20Course%20Trailer)%20Web%20Design%20Becoming%20a%20Professional-tcbh0yqBgns-1080p-1644604251925.mp4?alt=media&token=34417005-13eb-4a9a-a998-c76a0a09c022";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_main_menu);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        expandableNavigationListView=(ExpandableNavigationListView)findViewById(R.id.expandable_navigation);

        expandableNavigationListView
                .init(this)
                .addHeaderModel(new HeaderModel("Course Details", R.drawable.ic_baseline_menu_book_24))
                .addHeaderModel(
                        new HeaderModel("Section 1- Basics", R.drawable.ic_baseline_add_reaction_24, true)
                                .addChildModel(new ChildModel("Basics Of Web Development"))
                                .addChildModel(new ChildModel("Introduction to HTML and CSS"))
                )

                .addHeaderModel(
                        new HeaderModel("Section 2- Easy", R.drawable.ic_baseline_add_reaction_24, true)
                                .addChildModel(new ChildModel("Introduction to Sql"))
                                .addChildModel(new ChildModel("SQL in Web Development"))
                )

                .addHeaderModel(
                        new HeaderModel("Section 3- Medium", R.drawable.ic_baseline_add_reaction_24, true)
                                .addChildModel(new ChildModel("Various frameworks used for web"))
                                .addChildModel(new ChildModel("Implementation of Frameworks"))
                )

                .addHeaderModel(
                        new HeaderModel("Section 4- Advanced", R.drawable.ic_baseline_add_reaction_24, true)
                                .addChildModel(new ChildModel("Building a Food Website"))
                                .addChildModel(new ChildModel("Give Final Test"))
                )
                .addHeaderModel(new HeaderModel("Claim your certificate", R.drawable.ic_baseline_wallpaper_24))
                .build()
                .addOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                       expandableNavigationListView.setSelected(groupPosition);
                        return false;
                    }
                })
                .addOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        expandableNavigationListView.setSelected(groupPosition, childPosition);

                        if (groupPosition==5 && childPosition==0) {

                            Toast.makeText(CourseMainMenu.this, "Hi", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),GenerateCertificate.class));
                        }
                        return false;
                    }
                });

        expandableNavigationListView.setSelected(0);


        SimpleExoPlayer simpleExoPlayer=new SimpleExoPlayer.Builder(this).build();

        PlayerView playerView=findViewById(R.id.exoplaya_play_one);

        playerView.setPlayer(simpleExoPlayer);
        MediaItem mediaItem=MediaItem.fromUri(url);
        simpleExoPlayer.addMediaItem(mediaItem);

        simpleExoPlayer.prepare();



    }
}