package com.ja20049996.proficiencyexercise.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ja20049996.proficiencyexercise.R;
import com.ja20049996.proficiencyexercise.model.RowItems;
import com.ja20049996.proficiencyexercise.presenter.CanadaApiPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FactsView {
    
    private final ArrayList<RowItems> listRows = new ArrayList<>();
    private ProgressBar progress;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RowsAdapter adapter;
    private CanadaApiPresenter countryPresenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RecyclerView recyclerView = findViewById(R.id.card_recycler_view);
        progress = findViewById(R.id.progress);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        recyclerView.setHasFixedSize(true);
        countryPresenter = new CanadaApiPresenter(MainActivity.this, getApplicationContext());
        
        adapter = new RowsAdapter(listRows);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        
        // Maybe it's best to call it on onResume()
        progress.setVisibility(View.VISIBLE);
        countryPresenter.getData();

        /*
        set the pull to refresh logic
         */
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                progress.setVisibility(View.VISIBLE);
                countryPresenter.getData();
            }
        });
    }
    
    @Override
    public void showError(String err) {
        progress.setVisibility(View.GONE);
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void onFail(String error) {
        progress.setVisibility(View.GONE);
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void factsData(String title, List<RowItems> rows) {
        progress.setVisibility(View.GONE);
        setTitle(title);
        
        swipeRefreshLayout.setRefreshing(false);
        
        if (rows != null && rows.size() > 0) {
            listRows.clear();
            listRows.addAll(rows);
            adapter.notifyDataSetChanged();
        }
    }
}
