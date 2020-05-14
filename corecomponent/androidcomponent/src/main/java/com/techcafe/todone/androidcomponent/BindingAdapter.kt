package com.techcafe.todone.androidcomponent

import android.content.res.Resources
import android.view.View
import androidx.databinding.BindingAdapter

/**
 * should pass this BindingAdapter resource id.
 * if someone pass not resource id, the value assigns height of the view.
 * @param resource: e.g R.dimen.hoge
 */
@BindingAdapter("layout_height")
fun View.setLayoutHeight(resource: Int) {

    val height = try {
        resources.getDimension(resource).toInt()
    } catch (e: Resources.NotFoundException) {
        resource
    }
    layoutParams = layoutParams?.also {
        it.height = height
    }
}

@BindingAdapter("isVisible")
fun View.setVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}
