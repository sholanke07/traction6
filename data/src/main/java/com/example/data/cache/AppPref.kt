package com.example.data.cache

import android.content.SharedPreferences
import com.pixplicity.easyprefs.library.Prefs

object AppPref{

    var isAuth: Boolean
        get() = Prefs.getBoolean("isAuth", false)
        set(isAuth) = Prefs.putBoolean("isAuth", isAuth)

    var token: String
        get() = Prefs.getString("token", "")
        set(token) = Prefs.putString("token", token)

    var isOnline: Boolean
        get() = Prefs.getBoolean("isOnline", false)
        set(isOnline) = Prefs.putBoolean("isOnline", isOnline)

    var businessId: String
        get() = Prefs.getString("businessId", "")
        set(businessId) = Prefs.putString("businessId", businessId)

    var businessCreated: String
        get() = Prefs.getString("businessCreated", "")
        set(businessCreated) = Prefs.putString("businessCreated", businessCreated)

    var userStores: String
        get() = Prefs.getString("user_stores", "")
        set(userStores) = Prefs.putString("user_stores", userStores)

    var userName: String
        get() = Prefs.getString("userName", "")
        set(userName) = Prefs.putString("userName", userName)

    var userId: String
        get() = Prefs.getString("userId", "")
        set(userId) = Prefs.putString("userId", userId)

    var permissions: String
        get() = Prefs.getString("perm", "")
        set(permissions) = Prefs.putString("perm", permissions)

    var paymentOptions: String
        get() = Prefs.getString("paymentOptions", "")
        set(paymentOptions) = Prefs.putString("paymentOptions", paymentOptions)


}

