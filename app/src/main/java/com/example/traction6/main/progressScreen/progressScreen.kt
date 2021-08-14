package com.example.traction6.main.progressScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.traction6.R

class progressScreen : DialogFragment(){
    override fun onStart() {
        super.onStart()
        try {
            val window = dialog?.window
            window!!.setBackgroundDrawableResource(android.R.color.transparent)
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        } catch (e: Exception) {
            dismiss()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        isCancelable = false
        return inflater.inflate(R.layout.page_traction_progress, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}