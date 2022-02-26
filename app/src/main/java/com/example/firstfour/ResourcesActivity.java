package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ResourcesActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    ImageView iv;
    View view;

    List<UserModel> userModelList = new ArrayList<>();

    String[] articles = {
            "How to speak confidently",
            "10 tips for better communication",
            "How to offer criticism",
            "5 things to keep in mind while writing E-mails"
    };

    UsersAdapter usersAdapter;
    UsersAdapter.SelectedUser selectedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        view = getLayoutInflater().inflate(R.layout.row_users, null);
        recyclerView = findViewById(R.id.rv);
        iv = view.findViewById(R.id.article_trigger);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
            }
        });

        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        for(String s:articles){
            UserModel userModel = new UserModel(s);

            userModelList.add(userModel);
        }

        usersAdapter = new UsersAdapter(userModelList, selectedUser);

        recyclerView.setAdapter(usersAdapter);

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}