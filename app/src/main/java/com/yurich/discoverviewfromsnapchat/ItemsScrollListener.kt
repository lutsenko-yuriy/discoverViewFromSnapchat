package com.yurich.discoverviewfromsnapchat

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by yurich on 15.06.17.
 */
class ItemsScrollListener(
        val layoutManager: RecyclerView.LayoutManager,
        val update: () -> Unit
) : RecyclerView.OnScrollListener() {

    val visibleThreshold = 5
    var currentPage = 0
    var previousTotalItemCount = 0
    var loading = true;
    var startingPageIndex = 0;

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        val lastVisibleItemPosition
                = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        val totalItemCount = layoutManager.getItemCount()

        if (totalItemCount < previousTotalItemCount) {
            this.previousTotalItemCount = totalItemCount
            if (totalItemCount == 0) {
                this.loading = true
            }
        }

        if (loading && (totalItemCount > previousTotalItemCount)) {
            loading = false;
            previousTotalItemCount = totalItemCount;
        }

        if (!loading && (lastVisibleItemPosition + visibleThreshold) > totalItemCount) {
            update()
            loading = true
        }
    }

    fun resetState() {
        this.previousTotalItemCount = 0
        this.loading = true
    }

}
