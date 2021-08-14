package com.example.traction6

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.journeyapps.barcodescanner.CaptureActivity

class AnyOrientationCaptureActivity : CaptureActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_any_orientation_capture)
    }
}