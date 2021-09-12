package com.example.data.repository

import com.example.data.Entities.BarcodeUsers
import com.example.data.Network.ApiClient
import com.example.data.Network.apis.AuthenticationApi
import com.example.data.app.RoomDB.RoomApp
import com.example.data.cache.AppPref.token
import com.example.data.remote.model.NetworkResponses
import com.example.data.remote.model.retroObj.NetworkRequest
import io.reactivex.Observable

open class AuthRepository(
    val api: AuthenticationApi = ApiClient.retrofit.create(AuthenticationApi::class.java)

) {




       // val codeDao = RoomApp.getAppDatabase((getApplication()))?.codeDao()
       // codeDao?.insertUser(entity)
      //  getAllUsers()

    /*fun updateUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
        userDao?.updateUser(entity)
        getAllUsers()
    }
    fun deleteUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
        userDao?.deleteUser(entity)
        getAllUsers()
    }*/

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

