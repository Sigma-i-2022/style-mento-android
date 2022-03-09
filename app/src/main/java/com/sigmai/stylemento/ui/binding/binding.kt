package com.sigmai.stylemento.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sigmai.stylemento.global.util.GlideUtil

@BindingAdapter("app:imageUrl")
fun bindImageUrl(view: ImageView, imageUrl: String) {
    GlideUtil.setImageWithRadius(imageUrl, view, 12)
}