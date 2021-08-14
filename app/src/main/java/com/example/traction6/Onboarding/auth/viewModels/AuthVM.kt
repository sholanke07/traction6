package com.example.traction6.Onboarding.auth.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.viewbinding.BuildConfig
import com.example.domain.states.DataStates
import com.example.domain.states.authSuccess
import com.example.domain.useCases.AuthUsecase
import com.example.traction6.exts.standard
import io.reactivex.disposables.CompositeDisposable

open class AuthVM (private val authUsecase: AuthUsecase) : ViewModel(){

    val authentication = MutableLiveData<DataStates>()


    private val compositeDisposable = CompositeDisposable()


    fun authUser(email: String, password: String) {
        compositeDisposable.add(
            authUsecase.signInUser(email, password)
                .standard(authentication)
                .subscribe {
                    if (!BuildConfig.DEBUG) {
                        // FirebaseCrashlytics.getInstance().setUserId(email)
                    }
                    authentication.postValue(it)
                   if (it is authSuccess) {
                        // WorkManagerUtil.scheduleOneTimeWork(TractionAllDataWorker::class.java)

                       Log.d("anything", "anything")
                   }
                    else
                   {
                       Log.d("er", "errot")
                   }
                }
        )

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}