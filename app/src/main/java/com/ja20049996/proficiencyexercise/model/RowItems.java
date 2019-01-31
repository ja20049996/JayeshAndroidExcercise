package com.ja20049996.proficiencyexercise.model;

import android.os.Parcel;

import android.os.Parcelable;

 

public class RowItems implements Parcelable {

    private String imageHref;

 

    private String description;

 

    private String title;

 

    public String getImageHref ()

    {

        return imageHref;

    }

 

    public void setImageHref (String imageHref)

    {

        this.imageHref = imageHref;

    }

 

    public String getDescription ()

    {

        return description;

    }

 

    public void setDescription (String description)

    {

        this.description = description;

    }

 

    public String getTitle ()

    {

        return title;

    }

 

    public void setTitle (String title)

    {

        this.title = title;

    }

 

    @Override

    public String toString()

    {

        return "ClassPojo [imageHref = "+imageHref+", description = "+description+", title = "+title+"]";

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

 

    public RowItems() {

   }

 

    protected RowItems(Parcel in) {

        this.imageHref = in.readString();

        this.description = in.readString();

        this.title = in.readString();

    }

 

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

}