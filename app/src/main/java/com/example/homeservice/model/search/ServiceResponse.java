
package com.example.homeservice.model.search;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ServiceResponse {

    @SerializedName("professionId")
    private Long mProfessionId;
    @SerializedName("professionName")
    private String mProfessionName;
    @SerializedName("serviceIcon")
    private Object mServiceIcon;
    @SerializedName("slug")
    private String mSlug;

    public Long getProfessionId() {
        return mProfessionId;
    }

    public String getProfessionName() {
        return mProfessionName;
    }

    public Object getServiceIcon() {
        return mServiceIcon;
    }

    public String getSlug() {
        return mSlug;
    }
}
