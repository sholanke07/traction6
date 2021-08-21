package com.example.traction6.Onboarding.auth.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewViewModelFactory(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NewViewModel::class.java)){
            return NewViewModel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}