@file:Suppress("UNCHECKED_CAST")

package com.example.traction6.main.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object ProductVMFactory :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ProductsVM::class.java)) {
            ProductsVM() as T

        } else {
            throw IllegalArgumentException("ViewModel - ${modelClass.simpleName} not found")
        }


    }
}