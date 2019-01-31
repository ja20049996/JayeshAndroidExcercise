package com.ja20049996.proficiencyexercise.model;

import android.os.Parcel;

import android.os.Parcelable;

 

import java.util.ArrayList;

import java.util.List;

 

public class RestResponse implements Parcelable {

 

    private String title;

 

    private ArrayList<RowItems> rows;

 

    public String getTitle ()

    {

        return title;

    }

 

    public void setTitle (String title)

    {

        this.title = title;

    }

 

    public List<RowItems> getRows ()

    {

        return rows;

    }

 

    public void setRows (ArrayList<RowItems> rows)

    {

        this.rows = rows;

    }

 

    @Override

    public String toString()

    {

        return "ClassPojo [title = "+title+", rows = "+rows+"]";

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

 

    public RestResponse() {

    }

 

    protected RestResponse(Parcel in) {

        this.title = in.readString();

        this.rows = new ArrayList<RowItems>();

        in.readList(this.rows, RowItems.class.getClassLoader());

    }

 

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

}