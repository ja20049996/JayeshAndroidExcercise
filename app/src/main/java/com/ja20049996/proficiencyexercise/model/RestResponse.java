package com.ja20049996.proficiencyexercise.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Parcelable class
 *
 * @author Ja20049996
 */
public class RestResponse implements Parcelable {
    
    public static final Creator<RestResponse> CREATOR = new Creator<RestResponse>() {
        @Override
        public RestResponse createFromParcel(Parcel source) {
            return new RestResponse(source);
        }
        
        @Override
        public RestResponse[] newArray(int size) {
            return new RestResponse[size];
        }
    };
    
    private final String title;
    private final ArrayList<RowItems> rows;
    
    private RestResponse(Parcel in) {
        this.title = in.readString();
        this.rows = new ArrayList<>();
        in.readList(this.rows, RowItems.class.getClassLoader());
    }
    
    public String getTitle() {
        return title;
    }
    
    public List<RowItems> getRows() {
        return rows;
    }
    
    
    @NonNull
    @Override
    public String toString() {
        return "ClassPojo [title = " + title + ", rows = " + rows + "]";
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeList(this.rows);
    }
    
}