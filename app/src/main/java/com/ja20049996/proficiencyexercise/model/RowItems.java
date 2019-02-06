package com.ja20049996.proficiencyexercise.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;


public class RowItems implements Parcelable {
    
    public static final Creator<RowItems> CREATOR = new Creator<RowItems>() {
        @Override
        public RowItems createFromParcel(Parcel source) {
            return new RowItems(source);
        }
        
        @Override
        public RowItems[] newArray(int size) {
            return new RowItems[size];
        }
    };
    
    private String imageHref;
    private String description;
    private String title;
    
    private RowItems(Parcel in) {
        this.imageHref = in.readString();
        this.description = in.readString();
        this.title = in.readString();
    }
    
    public String getImageHref() {
        return imageHref;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getTitle() {
        return title;
    }
    
    @NonNull
    @Override
    public String toString() {
        return "ClassPojo [imageHref = " + imageHref + ", description = " + description + ", title = " + title + "]";
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageHref);
        dest.writeString(this.description);
        dest.writeString(this.title);
    }
}