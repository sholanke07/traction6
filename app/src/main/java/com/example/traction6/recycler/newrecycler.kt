package com.example.traction6.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.traction6.R
import com.example.traction6.factory.UIFactoryAdapter
import kotlinx.android.synthetic.main.fragment_newrecycler.*
import kotlinx.android.synthetic.main.fragment_recyclerview.*


class newrecycler : Fragment() {

     private lateinit var madapter: Adapter

    private var myView = ArrayList<String>()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_newrecycler, container, false)
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

//        recycler()
//        show()
            myView.add("DAM")
            myView.add("ttt")
            myView.add("uuu")
            madapter = Adapter(myView)
            val layoutManager = LinearLayoutManager(requireContext())
            new_recycler.layoutManager = layoutManager
            val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            new_recycler.addItemDecoration(divider)
            new_recycler.adapter = madapter

            madapter.notifyDataSetChanged()


   }
    fun recycler(){
        madapter = Adapter(myView)
        val layoutManager = LinearLayoutManager(requireContext())
        new_recycler.layoutManager = layoutManager
        new_recycler.adapter = madapter

    }
    fun show(){
        myView.add("Boy")
        myView.add("Girl")
        madapter.notifyDataSetChanged()
    }


}