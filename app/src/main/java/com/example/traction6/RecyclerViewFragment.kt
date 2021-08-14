package com.example.traction6

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.domain.exts.observe
import com.example.domain.exts.withViewModel
import com.example.traction6.factory.`interface`.FactoryEventAdapter
import com.example.traction6.factory.uiField.BarcodeField
import com.example.traction6.factory.uiField.UIField
import com.example.traction6.main.ScanBarcodeFragment
import com.example.traction6.main.sharedSceens.PagesFragment
import com.example.traction6.main.sharedSceens.ResultActivity
import com.example.traction6.main.vms.ProductVMFactory
import com.example.traction6.main.vms.ProductsVM
import kotlinx.android.synthetic.main.fab.*
import kotlinx.android.synthetic.main.fragment_recyclerview.*
import pub.devrel.easypermissions.EasyPermissions

//import pub.devrel.easypermissions.RationaleDialogFragmentCompat.TAG


class RecyclerViewFragment :  PagesFragment(), EasyPermissions.PermissionCallbacks {
    val RC_STORAGE = 1

   // private val RC_CAMERA_PERM = 123

    private var productsVM: ProductsVM? = null

    //var myList = ArrayList<String>()

     override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
       activity?.onBackPressed()
   }

   override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
       ui()
   }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        EasyPermissions.requestPermissions(
                /*this,
                getString(R.string.rationale_storage),
                RC_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.CAMERA*/

                this, getString(R.string.rationale_storage),
                RC_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE
                , android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA
        )
        //activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

       // val myAdapter = ListAdapter(requireContext(), myList)

        /*factory_recycler.adapter = myAdapter
        factory_recycler.layoutManager = LinearLayoutManager(requireContext())
        val decorator = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        factory_recycler.addItemDecoration(decorator)
        myAdapter.notifyDataSetChanged()*/



    }


    private fun ui() {
        factory_recycler.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        fab_create.setOnClickListener {
            // Navigation.findNavController(it).navigate(R.id.action_recyclerViewFragment_to_countingFragment)
            scanBarcode()
            // cameraTask()


        }


        // itemListener?.onSaveProductItem(factoryItemsAdapter)
        productsVM = withViewModel(ProductVMFactory) {
            //createProductForm(tractionProducts)
            observe(uiFields, ::updateUIFields)
           // observe(productCreate, ::productCreationUpdate)
        }

        factoryItemsAdapter.setEventAdapter(object : FactoryEventAdapter() {

            //filling items info and clicking
            override fun onItemClicked(uiField: UIField, params: Any) {
                when (uiField) {
                    is BarcodeField -> {
                        scanBarcode()

                    }
                }
            }
        })
    }

            // for the scan code, to scan or generate barcode showing dialog
           /* private fun showBarcodeDialog() {
        val dialog = Dialog(requireContext(), android.R.style.Theme_Translucent).also {
            it.requestWindowFeature(Window.FEATURE_NO_TITLE)
            val view =
                LayoutInflater.from(context).inflate(R.layout.dialog_barcode_action, null, false)
                    .apply {
                        btn_generate_code.setOnClickListener { _ ->
                            showProgress()
                          //  productsVM?.generateBarcode()
                            it.dismiss()
                        }
                        fab_create.setOnClickListener { _ ->
                            Toast.makeText(requireContext(), "Hello", Toast.LENGTH_SHORT).show()
                            it.dismiss()
                            Toast.makeText(requireContext(), "Hello", Toast.LENGTH_SHORT).show()
                            scanBarcode()

                        }
                        container.setOnClickListener { _ ->
                            it.dismiss()
                        }
                    }
            it.setContentView(view)
        }
        dialog.show()
    }*/

   /* private fun hasCameraPermission():Boolean {
        return EasyPermissions.hasPermissions(requireContext(), Manifest.permission.CAMERA)
    }
    fun cameraTask() {
        if (hasCameraPermission())
        {
            val integrator = IntentIntegrator.forSupportFragment(this)

            integrator.setOrientationLocked(true)
            integrator.setPrompt("Scan QR code")
            integrator.setBeepEnabled(true)
            integrator.setCameraId(0)
           // integrator.captureActivity = AnyOrientationCaptureActivity::class.java
            integrator.setOrientationLocked(true)
           // integrator.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES)
            integrator.initiateScan()

        }
        else
        {
            // Ask for one permission
            EasyPermissions.requestPermissions(
                    this,
                    getString(R.string.rationale_camera),
                    RC_CAMERA_PERM,
                    Manifest.permission.CAMERA
            )
        }
    }
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        Log.d(TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size)
        activity?.onBackPressed()

        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms))
        {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        Log.d(TAG, "onPermissionsGranted:" + requestCode + ":" + perms.size)
       // ui()
    }

    @SuppressLint("StringFormatMatches")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(requireContext(), "cancelled", Toast.LENGTH_SHORT).show()
            } else {
                Log.d("RecyclerViewFragment", "Scanned")
                Toast.makeText(requireContext(), "Scanned -> " + result.contents, Toast.LENGTH_SHORT)
                        .show()
                //testTV.text = String.format( "%s", result)
                testTV.text = String.format(result.contents)
                //myList.add(testTV.toString())


            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }*/


        /*if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE)
        {
            val yes = getString(R.string.yes)
            val no = getString(R.string.no)



            // Do something after user returned from app settings screen, like showing a Toast.
           /* Toast.makeText(
                requireContext(), getString(R.string.returned_from_app_settings_to_activity,
                    if (hasCameraPermission()) yes else no,
                    Toast.LENGTH_LONG).show()*/
        }*/

   /* override fun onRationaleAccepted(requestCode:Int) {
        Log.d(TAG, "onRationaleAccepted:" + requestCode)
    }
    override fun onRationaleDenied(requestCode:Int) {
        Log.d(TAG, "onRationaleDenied:" + requestCode)
    }*/


    // getting barcode result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SCAN_BARCODE && resultCode == Activity.RESULT_OK) {
            passBarcodeToView(data?.getStringExtra("data")!!)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }



    private fun passBarcodeToView(barcode: String) {
        productsVM?.updateBarcodeField(factoryItemsAdapter, barcode)

    }


}