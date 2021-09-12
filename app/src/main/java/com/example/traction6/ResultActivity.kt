package com.example.traction6

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.traction6.main.sharedSceens.Constants
import java.io.Serializable

open class ResultActivity : AppCompatActivity() {

    @SuppressLint("RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)



        //val scanBarcodeFragment = ScanBarcodeFragment()
        //supportFragmentManager.beginTransaction().replace(R.id.fragment_container, scanBarcodeFragment).commit()



       /* val bundle = intent.extras
        if (bundle != null ) {
            val barcode = bundle.getString("barcode")

            if (barcode != null) {
                returnBundle(barcode)
            }
        }*/
    }


   /* private fun returnBundle(serializableExtra: Serializable) {
        this.setResult(
            Activity.RESULT_OK,
            Intent().putExtra(Constants.DATA_KEY, serializableExtra)
        )
        finish()
    }*/


   /* override fun onScanResultReady(barcode: String) {
        val bundle = Bundle()
        bundle.putString("message", barcode)

        val transaction = this.supportFragmentManager.beginTransaction()
        val recyclerViewFragment = RecyclerViewFragment()
        recyclerViewFragment.arguments = bundle
        transaction.replace(R.id.fragment_container, recyclerViewFragment)
        transaction.commit()
    }*/
}
