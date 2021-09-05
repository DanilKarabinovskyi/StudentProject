package danyil.karabinovskyi.studentproject.ui.primary.friends_recommendation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import danyil.karabinovskyi.studentproject.base.BindingHolder
import danyil.karabinovskyi.studentproject.databinding.ItemFriendBinding
import danyil.karabinovskyi.studentproject.domain.friends.entity.FriendEntity
import danyil.karabinovskyi.studentproject.utils.diff_callbacks.FriendsDiffCallback
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

class FriendsRecommendationAdapter(
    private val onClick: (preference: FriendEntity) -> Unit
) : ListAdapter<FriendEntity, BindingHolder<ItemFriendBinding>>(FriendsDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingHolder<ItemFriendBinding> =
        BindingHolder(
            ItemFriendBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )

    override fun onBindViewHolder(holder: BindingHolder<ItemFriendBinding>, position: Int) {
        val item = getItem(holder.adapterPosition)
        holder.binding.item = item

        holder.binding.root.setOnClickWithDebounce {
            onClick(getItem(holder.adapterPosition))
        }
    }
}