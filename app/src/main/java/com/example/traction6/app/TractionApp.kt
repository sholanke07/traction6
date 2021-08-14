package com.example.traction6.app

import com.example.data.app.DataPrefsApplication
import com.example.traction6.BuildConfig
import com.google.firebase.crashlytics.FirebaseCrashlytics

class TractionApp: DataPrefsApplication() {

    companion object {
        lateinit var tApp: TractionApp
    }

    override fun onCreate() {
        super.onCreate()
        tApp = this
        if (BuildConfig.DEBUG) {
           // Timber.plant(Timber.DebugTree())
        }
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
    }
}