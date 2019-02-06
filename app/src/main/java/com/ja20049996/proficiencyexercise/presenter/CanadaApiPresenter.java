package com.ja20049996.proficiencyexercise.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.ja20049996.proficiencyexercise.R;
import com.ja20049996.proficiencyexercise.model.RestResponse;
import com.ja20049996.proficiencyexercise.model.RowItems;
import com.ja20049996.proficiencyexercise.service.FactsService;
import com.ja20049996.proficiencyexercise.view.FactsView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * This class represents the country view interface.
 *
 * @author ja20049996
 */
public class CanadaApiPresenter {
    
    private final FactsView factView;
    private final Context mContex;
    private FactsService mFactService;
    
    public CanadaApiPresenter(FactsView view, Context contex) {
        this.factView = view;
        this.mContex = contex;
        
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
                        
                        if (data != null && data.getRows() != null && data.getRows().size() > 0) {
                            List<RowItems> result = data.getRows();
                            List<RowItems> filteredResult = new ArrayList<>();
    
                            for (int i = 0; i < result.size(); i++) {
                                if (!TextUtils.isEmpty(result.get(i).getDescription())) {
                                    filteredResult.add(result.get(i));
                                }
                            }
                            
                            factView.factsData(data.getTitle(), filteredResult);
                        } else {
                            factView.showError(mContex.getResources().getString(R.string.err_no_data));
                        }
                    }
                    
                    @Override
                    public void onFailure(Call<RestResponse> call, Throwable t) {
                        factView.onFail(mContex.getResources().getString(R.string.err_server));
                    }
                });
    }
}
