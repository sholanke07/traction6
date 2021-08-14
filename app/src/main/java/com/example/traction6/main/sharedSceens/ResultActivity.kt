package com.example.traction6.main.sharedSceens

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.traction6.R
import com.journeyapps.barcodescanner.CaptureActivity
import java.io.Serializable

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bundle = intent.extras
        if (bundle != null) {
            val barcode = bundle.getString("barcode")

            if (barcode != null) {
                returnBundle(barcode)
            }
        }
    }

    private fun returnBundle(serializableExtra: Serializable) {
        this.setResult(
                Activity.RESULT_OK,
                Intent().putExtra(Constants.DATA_KEY, serializableExtra)
        )
        finish()
    }
}