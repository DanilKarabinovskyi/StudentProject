package danyil.karabinovskyi.studentproject.ui.primary.posts_recommendation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import danyil.karabinovskyi.studentproject.base.BindingHolder
import danyil.karabinovskyi.studentproject.databinding.ItemPostPrimaryBinding
import danyil.karabinovskyi.studentproject.domain.posts.entity.PostEntity
import danyil.karabinovskyi.studentproject.utils.diff_callbacks.PostsDiffCallback
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

class PostsRecommendationAdapter(
        private val onClick: (preference: PostEntity) -> Unit
) : ListAdapter<PostEntity, BindingHolder<ItemPostPrimaryBinding>>(PostsDiffCallback) {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): BindingHolder<ItemPostPrimaryBinding> =
            BindingHolder(
                    ItemPostPrimaryBinding.inflate(
                            LayoutInflater.from(
                                    parent.context
                            ), parent, false
                    )
            )

    override fun onBindViewHolder(holder: BindingHolder<ItemPostPrimaryBinding>, position: Int) {
        val item = getItem(holder.adapterPosition)
        holder.binding.item = item
        holder.binding.root.setOnClickWithDebounce {
            onClick(getItem(holder.adapterPosition))
        }
    }
}