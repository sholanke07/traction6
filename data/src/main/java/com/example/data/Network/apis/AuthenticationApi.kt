package com.example.data.Network.apis

import com.example.data.remote.model.NetworkResponses
import com.example.data.remote.model.retroObj.NetworkRequest
import io.reactivex.Observable
import retrofit2.http.*

interface AuthenticationApi {
    @POST("/v1/auth/login")
    fun login(@Body authentication: NetworkRequest.Login): Observable<NetworkResponses.AuthResponse>

    @GET("/v1/auth/check/{email}")
    fun userByEmail(@Path("email") email: String): Observable<NetworkResponses.Responses<String>>

    @PUT("/v1/auth/refresh/token")
    fun refreshToken(@Body resetData: NetworkRequest.RefreshToken): Observable<NetworkResponses.AuthResponse>
}