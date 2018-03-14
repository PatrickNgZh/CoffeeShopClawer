package com.patrick.informationfetcher.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * @author peicong
 * @date 2018/3/14 0014
 */
public class NumInfo {
    @SerializedName("count")
    private int count;

    @Override
    public String toString() {
        return Integer.toString(count);
    }
}
