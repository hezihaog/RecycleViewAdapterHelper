package com.hzh.recycle.view.adapter.helper.sample.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Package: com.hzh.recycle.view.adapter.helper.sample.util
 * FileName: ImageUtil
 * Date: on 2017/11/25  下午10:04
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class ImageUtil {
    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
    }
}
