package com.ja20049996.proficiencyexercise.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class represents the facts service.
 *
 * @author ja20049996
 */
public class FactsService {
    private Retrofit retrofit = null;
    
    /**
     * This method creates a new instance of the API interface.
     *
     * @return The API interface
     */
    public AboutCanadaAPI getAPI() {
        
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(ServicesConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        
        return retrofit.create(AboutCanadaAPI.class);
    }
}
