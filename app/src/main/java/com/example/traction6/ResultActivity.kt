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

         val bundle = intent.extras
        if (bundle != null ) {
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

    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.nav_graph).navigateUp()
}
