package com.example.data.app

import android.app.Application
import android.content.ContextWrapper
import com.pixplicity.easyprefs.library.Prefs
import io.reactivex.plugins.RxJavaPlugins

open class DataPrefsApplication: Application() {

    lateinit var tractionApp: DataPrefsApplication

    override fun onCreate() {
        super.onCreate()
        tractionApp = this
        Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(packageName)
                .setUseDefaultSharedPreference(true)
                .build()
        RxJavaPlugins.setErrorHandler {

        }

    }

}