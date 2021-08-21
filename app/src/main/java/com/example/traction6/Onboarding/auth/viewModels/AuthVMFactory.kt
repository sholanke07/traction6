package com.example.traction6.Onboarding.auth.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.Implementations.AuthUsecaseImpl


object AuthVMFactory : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthVM(AuthUsecaseImpl()) as T

    }


}