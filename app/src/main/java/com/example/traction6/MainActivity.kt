package com.example.traction6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class MainActivity : AppCompatActivity() {

  //  @SuppressLint("RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     /*   val bundle = intent.extras
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
    }

    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.nav_graph).navigateUp()*/
}
