package danyil.karabinovskyi.studentproject.ui.custom.bindings

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

object RecyclerViewBindings {
    @JvmStatic
    @BindingAdapter(
        value = ["imageUrl", "placeholder", "error", "transformation"],
        requireAll = false
    )
    fun loadImage(
            view: ImageView,
            url: String?,
            placeholder: Drawable?,
            error: Drawable?,
            transformation: Boolean?
    ) {
        val builder: RequestBuilder<Drawable> =
            Glide.with(view.context).load(url)
                .error(error)
        builder.into(view)
    }
}