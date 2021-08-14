package com.example.data.repository

import com.example.data.Network.ApiClient
import com.example.data.Network.apis.AuthenticationApi
import com.example.data.cache.AppPref.token
import com.example.data.remote.model.NetworkResponses
import com.example.data.remote.model.retroObj.NetworkRequest
import io.reactivex.Completable
import io.reactivex.Observable

open class AuthRepository (

    val api: AuthenticationApi = ApiClient.retrofit.create(AuthenticationApi::class.java)

) {

    fun refreshToken(): Observable<NetworkResponses.AuthResponse> {
        return api.refreshToken(NetworkRequest.RefreshToken(token = token))
    }

        fun auth(credential: NetworkRequest.Login): Observable<NetworkResponses.AuthResponse> {
            return api.login(credential)
                .doOnNext { response ->
                    response.data?.user?.let {

                        // tractionDb.userDao()
                        //   .createUser(TractionUser(it._id, credential.email, it.name.trim(), it.role, it.validated,
                        //     it.stores.map { storeNameId ->
                        // TractionBusinessStore(storeNameId.id, name = storeNameId.name,
                        //  has_register = storeNameId.register, business_name = it.business)
                    }
                    //toMutableList()
                }
        }


}

