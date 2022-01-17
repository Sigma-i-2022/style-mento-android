package com.sigmai.stylemento.global.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sigmai.stylemento.R

object GlideUtil {
    fun setImage(url: String, view: ImageView) {
        Glide.with(view.context)
            .load(url)
            .error(R.drawable.logo)
            .transform(CenterCrop(), RoundedCorners(999))
            .into(view)
    }
}