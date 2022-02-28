package com.example.firstfour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

public class Internships extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    CardView cd1;
    TextView explore_more,view_certificates;
    AlertDialog.Builder builder;
    private DrawerLayout mDrawerLayout;
    MaterialButton m1,m2;
    ImageButton back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internships);
        builder = new AlertDialog.Builder(this);


        m1=(MaterialButton)findViewById(R.id.todoB_live_intern);
        m2=(MaterialButton)findViewById(R.id.editProfileB_saved);
        back=(ImageButton)findViewById(R.id.backB);
        view_certificates=(TextView)findViewById(R.id.view_certi);

        view_certificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),GenerateCertificate.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LiveInternships.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SavedInternships.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.intern_drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_intern);
        navigationView.setNavigationItemSelectedListener(this);
        cd1=(CardView) findViewById(R.id.web_dev);
        explore_more=(TextView)findViewById(R.id.explore_more);

        explore_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Internships.this,ExploreMoreCourses.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Internships.this,LayoutForCourseView.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        cd1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

                builder.setMessage("Do you want to save this training ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"you choose yes action",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"you choose no action",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Add to Saved?");
                alert.show();

        return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_added_courses: {
                startActivity(new Intent(Internships.this,MyCart.class));
                break;
            }

            case R.id.nav_added_fav: {
                startActivity(new Intent(Internships.this,MyWIshlist.class));
                break;
            }

            case R.id.purchased_intern: {
                startActivity(new Intent(Internships.this,MyPurchases.class));
                break;
            }
        }
        //close navigation drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}