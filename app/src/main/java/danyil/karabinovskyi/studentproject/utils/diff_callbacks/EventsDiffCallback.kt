package danyil.karabinovskyi.studentproject.utils.diff_callbacks

import androidx.recyclerview.widget.DiffUtil
import danyil.karabinovskyi.studentproject.domain.events.entity.EventEntity

val EventsDiffCallback = object : DiffUtil.ItemCallback<EventEntity>() {
    override fun areItemsTheSame(oldItem: EventEntity, newItem: EventEntity): Boolean =
            oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: EventEntity, newItem: EventEntity): Boolean =
            oldItem == newItem

}