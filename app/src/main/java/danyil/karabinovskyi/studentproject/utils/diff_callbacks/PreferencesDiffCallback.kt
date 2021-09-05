package danyil.karabinovskyi.studentproject.utils.diff_callbacks

import androidx.recyclerview.widget.DiffUtil
import danyil.karabinovskyi.studentproject.domain.preferences.entity.PreferenceEntity


val PreferencesDiffCallback = object : DiffUtil.ItemCallback<PreferenceEntity>() {
    override fun areItemsTheSame(oldItem: PreferenceEntity, newItem: PreferenceEntity): Boolean =
        oldItem.title == newItem.title


    override fun areContentsTheSame(oldItem: PreferenceEntity, newItem: PreferenceEntity): Boolean =
        oldItem == newItem

}