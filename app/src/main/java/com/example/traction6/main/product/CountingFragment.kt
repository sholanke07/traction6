package com.example.traction6.main.product

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.traction6.R
import com.example.traction6.ScanBarcodeFragment
import com.example.traction6.main.sharedSceens.Constants
import com.example.traction6.main.sharedSceens.PagesFragment
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fragment_recyclerview.*
import kotlin.math.abs

open class CountingFragment: PagesFragment(){

    private var isScannerShowing: Boolean = false
    private lateinit var scanBarcodeFragment: ScanBarcodeFragment


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // tempCountId = Utils.getFormattedUUID()
        return inflater.inflate(R.layout.page_stock_counting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // initScanner()
    }

   /* private fun initScanner() {
        activity?.let {
            if (!it.isFinishing) {
                scanBarcodeFragment = ScanBarcodeFragment.newInstance(this)

                appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                    if (abs(verticalOffset) >= appBarLayout.totalScrollRange) { // collapse
                        childFragmentManager.beginTransaction().remove(scanBarcodeFragment).commit()
                        isScannerShowing = false
                    } else if (verticalOffset == 0) { // fully expand
                        isScannerShowing = true
                        childFragmentManager.beginTransaction().setCustomAnimations(R.anim.nav_default_enter_anim, R.anim.nav_default_pop_enter_anim,
                                R.anim.nav_default_exit_anim, R.anim.slide_out_to_right).replace(R.id.frame_scanner, scanBarcodeFragment, ScanBarcodeFragment.SCANNER_TAG).commitNow()
                    }
                })
            }
        }
    }*/
}

   /* private fun productFromBarcode(products: TractionProducts?) {
        stockCountVM?.increaseAndMoveUp(factoryItemsAdapter, products!!.id)
        factory_recycler.smoothScrollToPosition(0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SCAN_BARCODE_RESULT && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(Constants.DATA_KEY).let {
                stockCountVM?.countByBarcode(it!!)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (isScannerShowing) {
            childFragmentManager.beginTransaction().remove(scanBarcodeFragment).commitAllowingStateLoss()
        }
        stockCountVM?.productsData?.removeObservers(this)
    }

}*/