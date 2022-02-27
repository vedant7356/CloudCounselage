package com.example.firstfour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MyPurchases extends AppCompatActivity {

    private RecyclerView courseRV;
    private ArrayList<nav_layouts> coursesArrayList;
    private purchasedAdapter courseRVAdapter;

    RecyclerView recview;

    private FirebaseFirestore db;

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_purchases);

        b1=(Button) findViewById(R.id.buynow_ac_purchase);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CourseMainMenu.class));
            }
        });

//        recview=(RecyclerView)findViewById(R.id.recy_purchases);
//        db=FirebaseFirestore.getInstance();
//        coursesArrayList = new ArrayList<>();
//        recview.setHasFixedSize(true);
//        recview.setLayoutManager(new LinearLayoutManager(this));
//
//        courseRVAdapter = new purchasedAdapter(coursesArrayList, this);
//
//        // setting adapter to our recycler view.
//        recview.setAdapter(courseRVAdapter);
//
//        db.collection("Purchased").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        // after getting the data we are calling on success method
//                        // and inside this method we are checking if the received
//                        // query snapshot is empty or not.
//                        if (!queryDocumentSnapshots.isEmpty()) {
//                            // if the snapshot is not empty we are
//                            // hiding our progress bar and adding
//                            // our data in a list.
//                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
//                            for (DocumentSnapshot d : list) {
//                                // after getting this list we are passing
//                                // that list to our object class.
//                                nav_layouts c = d.toObject(nav_layouts.class);
//
//                                // and we will pass this object class
//                                // inside our arraylist which we have
//                                // created for recycler view.
//                                coursesArrayList.add(c);
//                            }
//                            // after adding the data to recycler view.
//                            // we are calling recycler view notifuDataSetChanged
//                            // method to notify that data has been changed in recycler view.
//                            courseRVAdapter.notifyDataSetChanged();
//                        } else {
//                            // if the snapshot is empty we are displaying a toast message.
//                            Toast.makeText(MyPurchases.this, "No data found in Database", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                // if we do not get any data or any error we are displaying
//                // a toast message that we do not get any data
//                Toast.makeText(MyPurchases.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}