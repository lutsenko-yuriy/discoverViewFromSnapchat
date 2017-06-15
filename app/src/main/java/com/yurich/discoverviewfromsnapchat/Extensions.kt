package com.yurich.discoverviewfromsnapchat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by yurich on 15.06.17.
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false)
        = LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun ImageView.load() {
    Glide.with(context)
            .load("http://lorempixel.com/$width/$height/")
            .into(this)
}