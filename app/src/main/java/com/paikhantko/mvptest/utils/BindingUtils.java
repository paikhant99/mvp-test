package com.paikhantko.mvptest.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.paikhantko.mvptest.R;

public class BindingUtils {
    public BindingUtils() {
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        if (!TextUtils.isEmpty(url)) Glide.with(context).load(url).into(imageView);
        else Glide.with(context).load(R.drawable.ic_launcher_background).into(imageView);

    }
}
