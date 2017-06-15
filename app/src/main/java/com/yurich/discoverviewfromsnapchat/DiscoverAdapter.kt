package com.yurich.discoverviewfromsnapchat

import android.support.v7.util.DiffUtil
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

    fun updateItems(items: ArrayList<String>) {
        val calculateDiff = DiffUtil.calculateDiff(object : DiffUtil.Callback(){
            override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
                return p0 == p1
            }

            override fun getOldListSize() = displayedItems.size

            override fun getNewListSize() = items.size

            override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
                return items[p1] == displayedItems[p0]
            }

        })
        calculateDiff.dispatchUpdatesTo(this)
    }
}