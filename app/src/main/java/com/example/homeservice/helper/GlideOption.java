package com.example.homeservice.helper;

import com.bumptech.glide.request.RequestOptions;
import com.example.homeservice.R;

public class GlideOption {
    public static RequestOptions getRequestOption() {
        return new RequestOptions()
                .placeholder(R.drawable.loading)
                .error(R.drawable.brand_logo);
    }

    public static RequestOptions getPersonReqOption() {
        return new RequestOptions()
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_filled_person);
    }
}
