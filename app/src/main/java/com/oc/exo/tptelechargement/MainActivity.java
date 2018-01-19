package com.oc.exo.tptelechargement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oc.exo.tptelechargement.adapter.HNArticlesAdapter;
import com.oc.hnapp.android.HNQueryTask;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HNArticlesAdapter hnArticlesAdapter;
    HNQueryTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        hnArticlesAdapter = new HNArticlesAdapter();
        recyclerView.setAdapter(hnArticlesAdapter);
        task = new HNQueryTask(hnArticlesAdapter, 80, 1);
        task.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        task.cancel(true);
    }
}
