package com.sigmai.stylemento.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.global.util.GlideUtil
import com.sigmai.stylemento.ui.home.adapter.TagAdapter

@BindingAdapter("app:imageUrl")
fun bindImageUrl(view: ImageView, imageUrl: String) {
    GlideUtil.setImage(imageUrl, view)
}

@BindingAdapter("app:imageUrl12")
fun bindImageUrlRadius12(view: ImageView, imageUrl: String) {
    GlideUtil.setImageWithRadius(imageUrl, view, 12)
}

@BindingAdapter("app:imageUrlCircle")
fun bindImageUrlCircle(view: ImageView, imageUrl: String?) {
    GlideUtil.setImageCircle(imageUrl, view)
}

@BindingAdapter("app:tags")
fun bindTags(view: RecyclerView, list: List<String>?) {
    list?.let {
        (view.adapter as TagAdapter).setList(list)
    }
}