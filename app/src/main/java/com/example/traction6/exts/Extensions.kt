package com.example.traction6.exts

import android.os.Build
import android.text.InputFilter
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.domain.exts.show
import com.example.traction6.R

fun EditText.setMaxLength(length: Int? = null) {
    length?.let {
        val filterArray = InputFilter.LengthFilter(length)
        this.filters = arrayOf(filterArray)
    } ?: kotlin.run {
        this.filters = arrayOf()
    }
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun View.passwordToggle(etPassword: EditText, ivToggler: ImageView) {
    if (etPassword.transformationMethod.javaClass.simpleName == "PasswordTransformationMethod") {
        etPassword.transformationMethod = SingleLineTransformationMethod()
        ivToggler.setImageDrawable(etPassword.context.getDrawable(R.drawable.ic_visibility_black_24dp))
    } else {
        etPassword.transformationMethod = PasswordTransformationMethod()
        ivToggler.setImageDrawable(etPassword.context.getDrawable(R.drawable.ic_visibility_off_black_24dp))
    }

    etPassword.setSelection(etPassword.text.length)
}

fun View.toggleVisibility(shouldShow: Boolean) {
    if (shouldShow) {
        this.show()
    } else {
       // this.hide()
    }
}