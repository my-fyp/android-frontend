package com.example.homeservice.helper;

import com.bumptech.glide.request.RequestOptions;
import com.example.homeservice.R;

public class GlideOption {
    public static RequestOptions getRequestOption() {
        return new RequestOptions()
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_baseline_broken_image_24);
    }
}
