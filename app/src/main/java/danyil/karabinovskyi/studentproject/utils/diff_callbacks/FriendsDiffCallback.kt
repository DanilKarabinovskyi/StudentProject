package danyil.karabinovskyi.studentproject.utils.diff_callbacks

import androidx.recyclerview.widget.DiffUtil
import danyil.karabinovskyi.studentproject.domain.friends.entity.FriendEntity
import danyil.karabinovskyi.studentproject.domain.preferences.entity.PreferenceEntity

val FriendsDiffCallback = object : DiffUtil.ItemCallback<FriendEntity>() {
    override fun areItemsTheSame(oldItem: FriendEntity, newItem: FriendEntity): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: FriendEntity, newItem: FriendEntity): Boolean =
        oldItem == newItem

}