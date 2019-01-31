package com.ja20049996.proficiencyexercise.presenter;

import android.util.Log;

import com.ja20049996.proficiencyexercise.model.RestResponse;
import com.ja20049996.proficiencyexercise.model.RowItems;
import com.ja20049996.proficiencyexercise.service.FactsService;
import com.ja20049996.proficiencyexercise.view.FactsView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * This class represents the country view interface.
 * @author ja20049996
 */
public class CanadaApiPresenter {

    private FactsView factView;
    private FactsService mFactService;

    public CanadaApiPresenter(FactsView view) {
        this.factView = view;

        if (this.mFactService == null) {
            this.mFactService = new FactsService();
        }
    }

    public void getData() {
        mFactService
                .getAPI()
                .getResults()
                .enqueue(new Callback<RestResponse>() {
                    @Override
                    public void onResponse(Call<RestResponse> call, Response<RestResponse> response) {
                        RestResponse data = response.body();

                        if (data != null && data.getRows() != null && data.getRows().size()>0) {
                            List<RowItems> result = data.getRows();
                            Log.e("responce",""+result);
                            factView.factsData(data.getTitle(),result);
                        }
                    }

                    @Override
                    public void onFailure(Call<RestResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
