package com.example.traction6


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.traction6.Onboarding.auth.viewModels.NewViewModel
import com.example.traction6.Onboarding.auth.viewModels.NewViewModelFactory
import com.example.traction6.factory.UIFactoryAdapter
import com.example.traction6.main.vms.ProductsVM

import kotlinx.android.synthetic.main.fab.*
import kotlinx.android.synthetic.main.fragment_recyclerview.*
import kotlin.collections.ArrayList

import kotlin.system.exitProcess


class RecyclerViewFragment : Fragment() {

    lateinit var uiFactoryAdapter: UIFactoryAdapter
    private var productsVM: ProductsVM? = null
    private var itemListener: CreateProductCallback? = null
    private lateinit var viewModel: NewViewModel
    private lateinit var viewModelFactory: NewViewModelFactory

    var myList = ArrayList<String>()

    /*init {

        val scanBarcodeFragment = ScanBarcodeFragment()
        scanBarcodeFragment.setScannerListener(this)
        scanBarcodeFragment.listener
    }*/

    /* companion object {
        val TAG: String = RecyclerViewFragment::class.java.simpleName
        var id = ""

        fun newInstance(listener: CreateProductCallback): RecyclerViewFragment {
            val arg = Bundle().apply {
                putSerializable(Constants.DATA_KEY, id)
            }

            return RecyclerViewFragment().apply {
                setCreateProductListener(listener)
                arguments = arg
            }
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recyclerview, container, false)
        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelFactory = NewViewModelFactory()
        val factory = NewViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(NewViewModel::class.java)

        initRecyclerView(view)
        //initViewModel()
        //stringToWords(mnemonic = String())

        // ui()

        fab_create.setOnClickListener {
            Navigation.findNavController(it)
                    .navigate(R.id.action_recyclerViewFragment_to_scanBarcodeFragment2)
        }
        val preferences =
                this.requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        val barcode = preferences.getString("newcode", " ")
        val item = ArrayList<String>()
       if (barcode != null) {
            item.add(barcode)
            uiFactoryAdapter?.setListData(item)
            uiFactoryAdapter?.notifyDataSetChanged()
            /* val preferences =
                this.requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        val barcode = preferences.getString("code", " ")
        var ret = barcode
        var retmake = ret + barcode
        val item = ArrayList<String>()
        if (retmake != null) {
            item.add(retmake)
            uiFactoryAdapter?.setListData(item)
            uiFactoryAdapter?.notifyDataSetChanged()*/


            btnSave.setOnClickListener {
                Toast.makeText(requireContext(), "All Items Saved" + " ", Toast.LENGTH_SHORT).show()

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
                            // } else {
                            // Toast.makeText(requireContext(), "press backpress again to exit app", Toast.LENGTH_SHORT).show()

                            // }
                            // backPressedTime = System.currentTimeMillis()
                        }
                    })

        }
    }



    private fun initRecyclerView(view: View) {
        factory_recycler.layoutManager = LinearLayoutManager(activity)
       // val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        //factory_recycler.addItemDecoration(divider)
        uiFactoryAdapter = UIFactoryAdapter(myList)
        factory_recycler.adapter = uiFactoryAdapter

    }
    /*private fun stringToWords(mnemonic: String): List<String> {
        val preferences =
                this.requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        val barcode = preferences.getString("code", " ")
        val item = ArrayList<String>()
        if (barcode != null){
            item.add(barcode)
            for (ret in mnemonic.trim(' ').split(" ")){
                if (ret.isNotEmpty())
                    item.add(ret)
            }
            uiFactoryAdapter?.notifyDataSetChanged()

        }
        return item
    }*/

}


    /* override fun onScanResultReady(barcode: String) {
       // welcome.setText(barcode)
       // if (barcode == null) {
           // Toast.makeText(requireContext(), "No", Toast.LENGTH_SHORT).show()
      //  }else{
           // Toast.makeText(requireContext(), "Yes", Toast.LENGTH_SHORT).show()
       // welcome.setText(barcode)
      val item = ArrayList<String>()
        if (barcode != null) {
           item.add(barcode)
            //uiFactoryAdapter.setListData(item)
            uiFactoryAdapter.notifyDataSetChanged()
       }
    }*/

   /* fun initViewModel() {
        // viewModel = ViewModelProvider(this).get(NewViewModel::class.java)
        // viewModel.getUserListObserverable().observe(
        //   {
        val preferences =
                this.requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        val barcode = preferences.getString("code", " ")
        val item = ArrayList<String>()
        if (barcode != null) {
            item.add(barcode)
            uiFactoryAdapter?.setListData(item)
            uiFactoryAdapter?.notifyDataSetChanged()

        }
        // },
        // )
        //  viewModel.getUserList()

    }*/


  /*  private fun ui() {
        factory_recycler.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        arguments?.getSerializable("data")?.let {
            // tractionProducts = it as TractionProducts
        }
    }*/

   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SCAN_BARCODE && resultCode == Activity.RESULT_OK) {
            passBarcodeToView(data?.getStringExtra("data")!!)
        }

    }

    private fun passBarcodeToView(barcode: String) {
        productsVM?.updateBarcodeField(factoryItemsAdapter, barcode)
    }

    fun setCreateProductListener(listener: CreateProductCallback) {
        itemListener = listener
    }*/







//finishAffinity()
//moveTaskToBack(true)
// exitProcess(-1)


/*fun onBackPassed(){
 if (backPressedTime + 2000 > System.currentTimeMillis()){
    //super.onBackPassed()
}else{
    Toast.makeText(requireContext(), "press backpress again to exit app", Toast.LENGTH_SHORT).show()
}
backPressedTime = System.currentTimeMillis()
}*/

/*class Demo : ScanBarcodeFragment.ScanResultListener {
    init {
        val scanBarcodeFragment = ScanBarcodeFragment()
        scanBarcodeFragment.setScannerListener(this)
        //scanBarcodeFragment.handleResult()
    }

    override fun onScanResultReady(barcode: String) {

    }*/









    



