package danyil.karabinovskyi.studentproject.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce


abstract class BaseListAdapter<T, Binding : ViewDataBinding>(
    var onClick: ((T) -> Unit)? = null,
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BindingHolder<Binding>>(diffCallback) {

    protected abstract val layoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<Binding> =
        BindingHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
        )

    override fun onBindViewHolder(holder: BindingHolder<Binding>, position: Int) {
        onClick?.let {
            holder.binding.root.setOnClickWithDebounce {
                it(getItem(holder.adapterPosition))
            }
        }
    }
}