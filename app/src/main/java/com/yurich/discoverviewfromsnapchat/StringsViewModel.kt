package com.yurich.discoverviewfromsnapchat

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by yurich on 15.06.17.
 */
class StringsViewModel: ViewModel() {

    val titles = MutableLiveData<ArrayList<String>>()

    fun getNewTitles() {
        titles.value?.let {
            if (it.isEmpty()) {
                it.addAll(StringsModel.randomStrings(30))
            } else {
                it.addAll(StringsModel.randomStrings(10))
            }
        }
    }
}