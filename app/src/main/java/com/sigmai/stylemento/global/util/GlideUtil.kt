package com.sigmai.stylemento.global.util

import android.util.DisplayMetrics
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sigmai.stylemento.R

object GlideUtil {
    fun setImage(url: String?, view: ImageView) {
        Glide.with(view.context)
            .load(url)
            .error(R.drawable.ic_logo)
            .circleCrop()
            .into(view)
    }

    fun setImageWithRadius(url: String?, view: ImageView, radius: Int) {
        val displayMetrics = view.context.resources.displayMetrics
        val radiusWithPixel = (displayMetrics.density * radius).toInt()

        Glide.with(view.context)
            .load(url)
            .error(R.drawable.ic_logo)
            .transform(CenterCrop(), RoundedCorners(radiusWithPixel))
            .into(view)
    }

    fun getRandomImageUrl() : String {
        val randomNumber = (180..250).random()
        return "https://picsum.photos/$randomNumber"
    }
}