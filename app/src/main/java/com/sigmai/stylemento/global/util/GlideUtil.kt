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
        if(url == null) return

        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.ic_logo)
            .error(R.drawable.ic_logo)
            .centerCrop()
            .into(view)
    }

    fun setImageWithRadius(url: String?, view: ImageView, radius: Int) {
        if(url == null) return

        val displayMetrics = view.context.resources.displayMetrics
        val radiusWithPixel = (displayMetrics.density * radius).toInt()

        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.ic_logo)
            .error(R.drawable.ic_logo)
            .transform(CenterCrop(), RoundedCorners(radiusWithPixel))
            .into(view)
    }

    fun setImageCircle(url: String?, view: ImageView) {
        if(url == null) return

        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.ic_default_photo)
            .error(R.drawable.ic_default_photo)
            .circleCrop()
            .into(view)
    }

    fun getRandomImageUrl() : String {
        val randomNumber = (180..250).random()
        return "https://picsum.photos/$randomNumber"
    }
}