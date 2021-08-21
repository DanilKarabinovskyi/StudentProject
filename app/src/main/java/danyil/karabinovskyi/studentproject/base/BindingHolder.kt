package danyil.karabinovskyi.studentproject.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingHolder<B : ViewDataBinding>(val binding: B) : RecyclerView.ViewHolder(binding.root)