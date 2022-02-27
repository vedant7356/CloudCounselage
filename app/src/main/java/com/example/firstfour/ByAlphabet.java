package com.example.firstfour;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ByAlphabet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ByAlphabet extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView courseRV;
    private ArrayList<MoreCourses> coursesArrayList;
    private viewcourseadapter courseRVAdapter;

    private String mParam1;
    private String mParam2;

    RecyclerView recview;

    private FirebaseFirestore db;
    ProgressBar loadingPB;
    public ByAlphabet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ByAlphabet.
     */
    // TODO: Rename and change types and number of parameters
    public static ByAlphabet newInstance(String param1, String param2) {
        ByAlphabet fragment = new ByAlphabet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_by_alphabet, container, false);
        recview=(RecyclerView)view.findViewById(R.id.alpha_recycler);
        loadingPB = view.findViewById(R.id.idProgressBaralpha);
        db=FirebaseFirestore.getInstance();
        coursesArrayList = new ArrayList<>();
        recview.setHasFixedSize(true);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        courseRVAdapter = new viewcourseadapter(coursesArrayList, getContext());

        // setting adapter to our recycler view.
        recview.setAdapter(courseRVAdapter);

        db.collection("Other Internship Trainings").orderBy("Name").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        // after getting the data we are calling on success method
                        // and inside this method we are checking if the received
                        // query snapshot is empty or not.
                        if (!queryDocumentSnapshots.isEmpty()) {
                            // if the snapshot is not empty we are
                            // hiding our progress bar and adding
                            // our data in a list.
                            loadingPB.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                // after getting this list we are passing
                                // that list to our object class.
                                MoreCourses c = d.toObject(MoreCourses.class);

                                // and we will pass this object class
                                // inside our arraylist which we have
                                // created for recycler view.
                                coursesArrayList.add(c);
                            }
                            // after adding the data to recycler view.
                            // we are calling recycler view notifuDataSetChanged
                            // method to notify that data has been changed in recycler view.
                            courseRVAdapter.notifyDataSetChanged();
                        } else {
                            // if the snapshot is empty we are displaying a toast message.
                            Toast.makeText(getContext(), "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // if we do not get any data or any error we are displaying
                // a toast message that we do not get any data
                Toast.makeText(getContext(), "Fail to get the data.", Toast.LENGTH_SHORT).show();
            }
        });

//        db.collection("Filter")
//                .whereEqualTo("Filter Selected","Healthy")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d("vedant", document.getId() + " => " + document.getData());
//
//                                String doc=document.getData().toString();
//                                tvdisp.setText(doc);
//
//
//
//                                //Toast.makeText(getContext(), doc, Toast.LENGTH_SHORT).show();
//                                //   Toast.makeText(getContext(), "Value Selected", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Log.d("parab", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });
//
//        db.collection("Filter")
//                .whereEqualTo("Filter Selected","Literate")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d("vedant", document.getId() + " => " + document.getData());
//
//                                String doc=document.getData().toString();
//                                tvdisp.setText(doc);
//
//
//
//                                //Toast.makeText(getContext(), doc, Toast.LENGTH_SHORT).show();
//                                //   Toast.makeText(getContext(), "Value Selected", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Log.d("parab", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });
        return view;
    }
}