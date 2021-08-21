package com.example.traction6

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
//import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.traction6.factory.UIFactoryAdapter
import com.example.traction6.factory.uiField.UIField
import com.example.traction6.main.vms.ProductsVM
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import pub.devrel.easypermissions.EasyPermissions
import java.lang.ref.WeakReference
import kotlin.system.exitProcess




class ScanBarcodeFragment : Fragment(), EasyPermissions.PermissionCallbacks, ZXingScannerView.ResultHandler {

    private val ZXING_CAMERA_PERMISSION = 1
    lateinit var mScannerView: ZXingScannerView
    var isProductScan = false

   //private var listener: ScanResultListener by lazy
    //var listener: ScanResultListener? = null

     lateinit var listener: ScanResultListener

    private var backPressedTime : Long = 0

   // private var listener = WeakReference<ScanResultListener>(null)

    companion object {
        val IS_PRODUCT_SCAN = "product_scan"
        const val SCANNER_TAG = "scanner_frag"

        fun newInstance(mListener: ScanResultListener): ScanBarcodeFragment {
            val sBFragment = ScanBarcodeFragment()
            sBFragment.setScannerListener(mListener)
            return sBFragment
        }
    }


    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        super.onResume()
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        activity?.onBackPressed()
    }

    override fun handleResult(rawResult: Result?) {

        val preferences = this.requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        var ret=preferences.getString("newcode", " ")
        ret= ret + "\n" + rawResult?.text
        preferences.edit()
               .putString("newcode", ret)
                .apply()
        mScannerView.resumeCameraPreview(this)
        findNavController().popBackStack()

      // listener.get()?.onScanResultReady(rawResult!!.text)
       // if (rawResult != null) {
           // listener?.onScanResultReady(rawResult!!.text)
       // }
       /*rawResult?.text?.let { listener?.onScanResultReady(it) }
       // if (rawResult != null) {
           // rawResult.text.toString()
       // }
        //Toast.makeText(requireContext(), rawResult?.text, Toast.LENGTH_SHORT).show()
        val handler = Handler()
        handler.postDelayed({ mScannerView.resumeCameraPreview(this@ScanBarcodeFragment) }, 2000)
        mScannerView.resumeCameraPreview(this)
        findNavController().popBackStack()*/

      /* isProductScan.let {
            if (it) {
                activity?.let { fragmentActivity ->

                    fragmentActivity.setResult(

                        Activity.RESULT_OK,

                        Intent().putExtra("data", rawResult?.text)
                    )
                   // Toast.makeText(requireContext(), rawResult!!.text, Toast.LENGTH_SHORT).show()

                    fragmentActivity.finish()


                }
            } else {
                listener?.onScanResultReady(rawResult!!.text)
                val handler = Handler()
                Toast.makeText(requireContext(), rawResult!!.text, Toast.LENGTH_SHORT).show()
                handler.postDelayed({ mScannerView.resumeCameraPreview(this@ScanBarcodeFragment) }, 2000)
                findNavController().popBackStack()
            }
        }*/

    }

   fun setScannerListener(mListener: ScanResultListener) {
        this.listener = (mListener)
    }

    interface ScanResultListener {
       fun onScanResultReady(barcode: String)

    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mScannerView = ZXingScannerView(activity)
        return mScannerView
        //return inflater.inflate(R.layout.fragment_s_b, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        EasyPermissions.requestPermissions(
                this, getString(R.string.rationale_camera),
                ZXING_CAMERA_PERMISSION, android.Manifest.permission.CAMERA
        )
        /*activity?.onBackPressedDispatcher?.addCallback(requireActivity(), object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
               // exitProcess(-2)
                    isEnabled = false

                    activity?.onBackPressed()
            }
       })*/
        /*activity?.intent?.let {
            /isProductScan = it.getBooleanExtra(ScanBarcodeFragment.IS_PRODUCT_SCAN, false)*/
    }

    override fun onResume() {
        super.onResume()
        mScannerView.setResultHandler(this)
        mScannerView.isSoundEffectsEnabled = true
        mScannerView.flash = true
        mScannerView.setAspectTolerance(0.2f)
        mScannerView.startCamera()
    }

    //when activity is pause
    override fun onPause() {
        super.onPause()
        mScannerView.setResultHandler(null)
        mScannerView.stopCamera()
    }

    //when activity is destroy
    override fun onDestroy() {
        super.onDestroy()
        mScannerView.setResultHandler(null)
        mScannerView.stopCamera()
    }


}








