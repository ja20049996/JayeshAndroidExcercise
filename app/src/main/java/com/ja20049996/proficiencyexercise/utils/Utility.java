package com.ja20049996.proficiencyexercise.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Utility {
    
    /**
     * to check internet connection
     *
     * @return boolean
     */
    public static boolean isInternetAvailable() {
        try {
            final InetAddress address = InetAddress.getByName("www.google.com");
            return !address.equals("");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return false;
    }
}
