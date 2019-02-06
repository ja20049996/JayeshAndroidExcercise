package com.ja20049996.proficiencyexercise.presenter;

import com.ja20049996.proficiencyexercise.model.RowItems;
import com.ja20049996.proficiencyexercise.utils.Utility;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by JA20049996 on 1/31/2019.
 */
public class CanadaApiPresenterTest {
    
    private final List<RowItems> NONEMPTY_ROWITEMS = new ArrayList<>();
    private final List<RowItems> EMPTY_ROWITEMS = new ArrayList<>();
    
    @Before
    public void setUp() {
        NONEMPTY_ROWITEMS.add(new RowItems("", "", ""));
    }
    
    @Test
    public void testNetConnection() {
        assertFalse("No Internet Conncection Available", !Utility.isInternetAvailable());
    }
    
    @Test
    public void testNonEmptyCanadaFactList() {
        assertTrue("NON-EMPTY LIST", NONEMPTY_ROWITEMS.size() > 0);
    }
    
    @Test
    public void testEmptyCanadaFactList() {
        assertEquals("EMPTY LIST", 0, EMPTY_ROWITEMS.size());
    }
    
}