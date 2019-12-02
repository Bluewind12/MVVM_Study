package momonyan.t.mvvm_study.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import momonyan.t.mvvm_study.databinding.ItemListLayoutBinding
import momonyan.t.mvvm_study.model.itemDataBase.Item
import momonyan.t.mvvm_study.view_model.ItemListViewModel

class ItemListAdapter(private val viewModel: ItemListViewModel, private val context: Context) :
    ListAdapter<Item, ItemListAdapter.ViewHolder>(ItemListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(viewModel, item)
    }

    class ViewHolder(private val binding: ItemListLayoutBinding, private val context: Context?) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: ItemListViewModel, item: Item) {
            binding.viewModel = viewModel
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup, context: Context?): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemListLayoutBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, context)
            }
        }
    }

}


class ItemListDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(
        oldItem: Item,
        newItem: Item
    ): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(
        oldItem: Item,
        newItem: Item
    ): Boolean {
        return oldItem == newItem
    }
}