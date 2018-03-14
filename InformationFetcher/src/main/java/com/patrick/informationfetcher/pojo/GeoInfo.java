package com.patrick.informationfetcher.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author peicong
 * @date 2018/3/13 0013
 */
public class GeoInfo {
    @SerializedName("geocodes")
    private List<Address> addressList;

    public List<Address> getAddressList() {
        if (addressList.size()==0){
            return null;
        }
        return addressList;
    }
}
