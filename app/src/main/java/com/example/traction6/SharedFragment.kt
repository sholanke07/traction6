package com.example.traction6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

open class SharedFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_nav_shared, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
           // val dest = it.intent.getIntExtra("data",R.id.action_sharedFragment_to_customerFragment)
           // Navigation.findNavController(it, R.id.nav_graph).navigate(dest)
        }
    }
}