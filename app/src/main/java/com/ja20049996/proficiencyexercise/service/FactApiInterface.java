package com.ja20049996.proficiencyexercise.service;

import com.ja20049996.proficiencyexercise.model.RestResponse;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * This class represents the facts API, all endpoints can stay here.
 *
 * @author ja20049996
 */
public interface FactApiInterface {
    
    @GET("facts.json")
    Call<RestResponse> getResults();
}
