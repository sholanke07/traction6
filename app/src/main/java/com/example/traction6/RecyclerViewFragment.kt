package com.example.traction6


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.data.Dao.CodeDao
import com.example.data.Entities.BarcodeUsers
import com.example.data.app.RoomDB.RoomApp
//import com.example.traction6.Onboarding.auth.viewModels.NewViewModel
import com.example.traction6.Onboarding.auth.viewModels.SharedViewModel
//import com.example.traction6.Onboarding.auth.viewModels.NewViewModel
//import com.example.traction6.Onboarding.auth.viewModels.NewViewModelFactory
import com.example.traction6.factory.UIFactoryAdapter
import com.example.traction6.main.vms.ProductsVM
import com.example.traction6.recycler.Adapter

import kotlinx.android.synthetic.main.fab.*
import kotlinx.android.synthetic.main.fragment_recyclerview.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

import kotlin.system.exitProcess


class RecyclerViewFragment : Fragment() {

    companion object {
        const val TAG = "RecyclerViewFragment"
    }

    private lateinit var madapter: Adapter

    var uiFactoryAdapter: UIFactoryAdapter? = null
    private var productsVM: ProductsVM? = null
    private var itemListener: CreateProductCallback? = null

    lateinit var locaDb: RoomApp
    lateinit var adapter: UIFactoryAdapter
    private val listData: ArrayList<BarcodeUsers> = ArrayList()


    // lateinit var newViewModel: NewViewModel
    // val item = ArrayList<String>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recyclerview, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fab_create.setOnClickListener {

            Navigation.findNavController(it)
                    .navigate(R.id.action_recyclerViewFragment_to_scanBarcodeFragment)

        }

        locaDb = RoomApp.getAppDatabase(requireContext())!!
        adapter = UIFactoryAdapter(requireActivity(), listData)

        factory_recycler.adapter = adapter
        factory_recycler.layoutManager = LinearLayoutManager(requireContext())
        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        factory_recycler.addItemDecoration(divider)


         listData.clear()
        thread {
            listData.addAll(locaDb.codeDao()?.getAllUserInfo()!!)
            runOnUiThread {
                Runnable {
                    Toast.makeText(requireContext(), "$listData", Toast.LENGTH_SHORT).show()

                    adapter.notifyDataSetChanged()
                }
            }
        }





        /* factory_recycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            uiFactoryAdapter = UIFactoryAdapter(myList)
            adapter = uiFactoryAdapter
            val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            addItemDecoration(divider)
        }*/
        // val item = ArrayList<BarcodeUsers>()
        // val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        // model.message.observe(viewLifecycleOwner, Observer {

        // item.add(it)


        // newViewModel = ViewModelProviders.of(this).get(NewViewModel::class.java)
        // newViewModel.getAllUsersObservers().observe(requireActivity(), androidx.lifecycle.Observer {
        //item.add(myList)
        /*uiFactoryAdapter?.setListData(item)
            uiFactoryAdapter?.notifyDataSetChanged()
            Toast.makeText(requireContext(), "$item", Toast.LENGTH_SHORT).show()*/


        // val model = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)

        //model.message.observe(viewLifecycleOwner, object : Observer<String> {
        //   override fun onChanged(barcode: String?) {


        //madapter = Adapter(myView)

        /*  val layoutManager = LinearLayoutManager(requireContext())
        factory_recycler.layoutManager = layoutManager
        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        factory_recycler.addItemDecoration(divider)
        factory_recycler.adapter = uiFactoryAdapter
        val item = ArrayList<String>()*/
        //if (myList != null) {
        // item.add(myList.toString())
        // uiFactoryAdapter = UIFactoryAdapter(item)


        // uiFactoryAdapter = UIFactoryAdapter(myList)
        // uiFactoryAdapter.setListData(myList)
        //uiFactoryAdapter.notifyDataSetChanged()
        //}


        btnSave.setOnClickListener {
            Toast.makeText(requireContext(), "All Data Saved", Toast.LENGTH_SHORT).show()
        }



        activity?.onBackPressedDispatcher?.addCallback(
                requireActivity(),
                object : OnBackPressedCallback(
                        true
                ) {
                    override fun handleOnBackPressed() {
                        //if(isInterceptBackPress()){
                        //  do your work here
                        //  if (backPressedTime + 2000 > System.currentTimeMillis()) {
                        isEnabled = false
                        exitProcess(1)
                        activity?.onBackPressed()

                    }
                })





    }

    private fun runOnUiThread(new: () -> Runnable) {

    }
}











    



