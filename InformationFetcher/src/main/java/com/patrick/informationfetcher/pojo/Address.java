package com.patrick.informationfetcher.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * @author peicong
 * @date 2018/3/13 0013
 */
public class Address {
    @SerializedName("location")
    private String location;

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Address{" +
                "location='" + location + '\'' +
                '}';
    }
}
