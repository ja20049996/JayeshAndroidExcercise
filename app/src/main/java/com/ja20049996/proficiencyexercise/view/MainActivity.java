package com.ja20049996.proficiencyexercise.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ja20049996.proficiencyexercise.R;

import com.ja20049996.proficiencyexercise.model.RowItems;
import com.ja20049996.proficiencyexercise.presenter.CanadaApiPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FactsView {

    private RecyclerView recyclerView;
    private ArrayList<RowItems> listRows = new ArrayList<>();
    private RowsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        CanadaApiPresenter countryPresenter = new CanadaApiPresenter(MainActivity.this);

        adapter = new RowsAdapter(listRows);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        // Maybe it's best to call it on onResume()
        countryPresenter.getData();
    }

    @Override
    public void factsData(String title,List<RowItems> rows) {

        setTitle(title);

        if(rows!=null && rows.size()>0){
            listRows.clear();
            listRows.addAll(rows);
            adapter.notifyDataSetChanged();
        }

    }

}
