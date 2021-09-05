package danyil.karabinovskyi.studentproject.ui.primary.events_recommendation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import danyil.karabinovskyi.studentproject.base.BindingHolder
import danyil.karabinovskyi.studentproject.databinding.ItemEventPrimaryBinding
import danyil.karabinovskyi.studentproject.domain.events.entity.EventEntity
import danyil.karabinovskyi.studentproject.utils.diff_callbacks.EventsDiffCallback
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

class EventsRecommendationAdapter(
        private val onClick: (preference: EventEntity) -> Unit
) : ListAdapter<EventEntity, BindingHolder<ItemEventPrimaryBinding>>(EventsDiffCallback) {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): BindingHolder<ItemEventPrimaryBinding> =
            BindingHolder(
                    ItemEventPrimaryBinding.inflate(
                            LayoutInflater.from(
                                    parent.context
                            ), parent, false
                    )
            )

    override fun onBindViewHolder(holder: BindingHolder<ItemEventPrimaryBinding>, position: Int) {
        val item = getItem(holder.adapterPosition)
        holder.binding.item = item
        holder.binding.root.setOnClickWithDebounce {
            onClick(getItem(holder.adapterPosition))
        }
    }
}