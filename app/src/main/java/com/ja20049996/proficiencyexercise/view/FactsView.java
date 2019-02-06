package com.ja20049996.proficiencyexercise.view;

import com.ja20049996.proficiencyexercise.model.RowItems;

import java.util.List;

/**
 * This class represents the facts view interface.
 *
 * @author ja20049996
 */
public interface FactsView {
    void factsData(String title, List<RowItems> countries);
    
    // showing error
    void showError(String error);
    
    // when network fail
    void onFail(String error);
}
