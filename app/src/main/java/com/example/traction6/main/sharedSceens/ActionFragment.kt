package com.example.traction6.main.sharedSceens

import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.traction6.R
import com.example.traction6.ResultActivity
import com.example.traction6.ScanBarcodeFragment
import com.example.traction6.ScanBarcodeFragment.Companion.IS_PRODUCT_SCAN
import com.example.traction6.main.progressScreen.progressAlert
import com.example.traction6.main.progressScreen.progressScreen
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class ActionFragment(val coroutineContext: CoroutineContext = Dispatchers.Main) : Fragment(),
    ScanBarcodeFragment.ScanResultListener{


        protected val REQUEST_CAPTURE_IMAGE = 100
        protected val SCAN_BARCODE = 110
        protected val SCAN_BARCODE_RESULT = 101
        protected val GENERATE_BARCODE = 120



        private lateinit var progressScreen: progressScreen
        private lateinit var progressAlert: progressAlert
        private var isShowing = false



        protected fun showProgress() {
            childFragmentManager.let {
                progressScreen = progressScreen()
                progressScreen.show(it, "")
                isShowing = true
            }
        }

        protected fun dismissProgress() {
            if (isShowing) {
                progressScreen.dismiss()
                isShowing = false
            }
        }

        protected fun scanBarcode() {
            startActivityForResult(
                Intent(context, ResultActivity::class.java)
                    .putExtra("data", R.id.action_recyclerViewFragment_to_scanBarcodeFragment2)
                    .putExtra(IS_PRODUCT_SCAN, true),
                SCAN_BARCODE
            )
        }

        protected fun setupRecyclerFabScrollListener(recyclerView: RecyclerView, fab: FloatingActionButton) {
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0 && fab.visibility == View.VISIBLE) {
                        fab.hide()
                    } else if (dy < 0 && fab.visibility != View.VISIBLE) {
                        fab.show()
                    }
                }
            })
        }

        override fun onScanResultReady(barcode: String) {
           startActivityForResult(
                Intent(context, ResultActivity::class.java)
                    .putExtra("barcode", barcode),
                SCAN_BARCODE_RESULT
            )
        }


    }