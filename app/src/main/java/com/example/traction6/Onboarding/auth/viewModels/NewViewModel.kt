package com.example.traction6.Onboarding.auth.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.traction6.model

class NewViewModel: ViewModel() {


        var lst = MutableLiveData<ArrayList<model>>()
        var newlist = arrayListOf<model>()

        fun add(blog: model) {
            newlist.add(blog)
            lst.value = newlist
        }
    lateinit var recyclerListData: MutableLiveData<model>

    init {
        recyclerListData = MutableLiveData()

    }

    fun getUserListObserverable(): MutableLiveData<model>{
        return recyclerListData
    }

}