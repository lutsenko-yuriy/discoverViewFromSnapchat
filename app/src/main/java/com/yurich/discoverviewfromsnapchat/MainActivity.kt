package com.yurich.discoverviewfromsnapchat

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : LifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders
                .of(this@MainActivity)
                .get(StringsViewModel::class.java)

        val adapter = DiscoverAdapter()
        val layoutManager = LinearLayoutManager(this)
        val scrollListener = ItemsScrollListener(layoutManager) {
            model.getNewTitles()
        }

        item_list.adapter = adapter
        item_list.layoutManager = layoutManager
        item_list.addOnScrollListener(scrollListener)

        model.titles.observe(this) {
            it?.let{
                scrollListener.resetState()
                adapter.updateItems(it)
            }
        }
    }
}
