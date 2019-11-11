
package com.synth3sisgame.synth3sisgame.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("bio")
    @Expose
    public String bio;
    @SerializedName("rating")
    @Expose
    public float rating;
    @SerializedName("license_no")
    @Expose
    public String licenseNo;
    @SerializedName("photo")
    @Expose
    public String photo;
    @SerializedName("joined")
    @Expose
    public String joined;

    @SerializedName("vehicle_no")
    @Expose
    public String vehicle_no;

    @SerializedName("vehicle_name")
    @Expose
    public String vehicle_name;

    @SerializedName("total_months")
    @Expose
    public int total_months;

    @SerializedName("total_rides")
    @Expose
    public int total_rides;

    @SerializedName("mobile")
    @Expose
    public String mobile;

}
