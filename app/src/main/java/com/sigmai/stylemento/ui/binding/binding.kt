package com.sigmai.stylemento.ui.binding

import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.global.util.GlideUtil
import com.sigmai.stylemento.ui.home.adapter.TagAdapter
import timber.log.Timber

@BindingAdapter("app:imageUrl", "app:imageRadius", requireAll = false)
fun bindImageUrl(view: ImageView, imageUrl: String?, radius: Int = 0) {
    if(radius == 0) GlideUtil.setImage(imageUrl, view)
    else GlideUtil.setImageWithRadius(imageUrl, view, radius)
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

@BindingAdapter("app:readOnly")
fun bindReadOnly(view: EditText, readOnly: Boolean = false) {
    view.isEnabled = !readOnly
}