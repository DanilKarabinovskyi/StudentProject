package danyil.karabinovskyi.studentproject.ui.preferences

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import danyil.karabinovskyi.studentproject.base.BindingHolder
import danyil.karabinovskyi.studentproject.databinding.ItemPreferencesBinding
import danyil.karabinovskyi.studentproject.domain.preferences.entity.PreferenceEntity
import danyil.karabinovskyi.studentproject.utils.diff_callbacks.PreferencesDiffCallback
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce

class PreferencesAdapter(
    private val onClick: (preference: PreferenceEntity) -> Unit
) : ListAdapter<PreferenceEntity, BindingHolder<ItemPreferencesBinding>>(PreferencesDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingHolder<ItemPreferencesBinding> =
        BindingHolder(
            ItemPreferencesBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )

    override fun onBindViewHolder(holder: BindingHolder<ItemPreferencesBinding>, position: Int) {
        val item = getItem(holder.adapterPosition)
        holder.binding.item = item

        holder.binding.root.setOnClickWithDebounce {
            onClick(getItem(holder.adapterPosition))
        }
    }
}