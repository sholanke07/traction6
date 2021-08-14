package com.example.traction6.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.traction6.R
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import pub.devrel.easypermissions.EasyPermissions

class ScanBarcodeFragment :  Fragment(), EasyPermissions.PermissionCallbacks, ZXingScannerView.ResultHandler {

    private val ZXING_CAMERA_PERMISSION = 1

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        activity?.onBackPressed()
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        super.onResume()
    }

    lateinit var mScannerView: ZXingScannerView
    var isProductScan = false
    lateinit var listener: ScanResultListener
    companion object {
        val IS_PRODUCT_SCAN = "product_scan"
        const val SCANNER_TAG = "scanner_frag"

        fun newInstance(mListener: ScanResultListener) : ScanBarcodeFragment {
            val scanBarcodeFragment = ScanBarcodeFragment()
            scanBarcodeFragment.setScannerListener(mListener)
            return scanBarcodeFragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mScannerView = ZXingScannerView(activity)
        return mScannerView
    }

    //taking camera permission
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        EasyPermissions.requestPermissions(
            this, getString(R.string.rationale_camera),
            ZXING_CAMERA_PERMISSION, android.Manifest.permission.CAMERA
        )
        activity?.intent?.let {
            isProductScan = it.getBooleanExtra(IS_PRODUCT_SCAN, false)
        }
    }

    //when activity is active
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
    //getting result and handling result
    override fun handleResult(rawResult: Result?) {
        isProductScan.let {
            if (it) {
                activity?.let { fragmentActivity ->
                    fragmentActivity.setResult(
                        Activity.RESULT_OK,
                        Intent().putExtra("data", rawResult?.text)
                    )
                    fragmentActivity.finish()
                }
            } else {
                listener.onScanResultReady(rawResult!!.text)
                val handler = Handler()
                handler.postDelayed({ mScannerView.resumeCameraPreview(this@ScanBarcodeFragment) }, 2000)
            }
        }
    }

    fun setScannerListener(mListener: ScanResultListener) {
        this.listener = mListener
    }

    interface ScanResultListener {
        fun onScanResultReady(barcode: String)
    }


}