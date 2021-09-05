package danyil.karabinovskyi.studentproject.utils.diff_callbacks

import androidx.recyclerview.widget.DiffUtil
import danyil.karabinovskyi.studentproject.domain.posts.entity.PostEntity

val PostsDiffCallback = object : DiffUtil.ItemCallback<PostEntity>() {
    override fun areItemsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean =
            oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean =
            oldItem == newItem

}