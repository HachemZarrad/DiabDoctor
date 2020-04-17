package com.example.diabdoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class docHome extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ExampleItem> exampleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        exampleList.add(new ExampleItem("document1"));
        exampleList.add(new ExampleItem("document2"));
        exampleList.add(new ExampleItem("document3"));
        exampleList.add(new ExampleItem("document4"));

        mRecyclerView = findViewById(R.id.container);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }



    public void openPdf(View v){
        Intent toCourse = new Intent(docHome.this, PDF.class);
        startActivity(toCourse);
    }
     int i = 4;
    public void addElement(View v) {
        i++;
        int j = mAdapter.getItemCount();
        String element =  "document "+i;
        exampleList.add(new ExampleItem(element));
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager.scrollToPosition(j);

    }
    }



