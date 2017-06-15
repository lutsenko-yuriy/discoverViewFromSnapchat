package com.yurich.discoverviewfromsnapchat

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * Created by yurich on 15.06.17.
 */
class DiscoverAdapter: RecyclerView.Adapter<DiscoverAdapter.ViewHolder>() {

    val displayedItems = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        (holder as ViewHolder).bind(displayedItems[position])
    }

    override fun getItemCount() = displayedItems.size

    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_layout)) {
        fun bind(title: String) = with(itemView) {
            item_title.text = title
            item_background.load()
        }
    }

    fun appendItems(items: ArrayList<String>) {
        val startItem = displayedItems.size
        displayedItems.addAll(items)
        notifyItemRangeInserted(startItem, items.size)
    }
}