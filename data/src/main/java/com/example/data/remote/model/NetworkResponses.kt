package com.example.data.remote.model

import com.example.data.remote.model.retroObj.ResponseData

sealed class NetworkResponses {
    open class Responses<T>(
        var status: Boolean = false,
        var message: String = "",
        val error: Any? = null,
        val data: T?
    )

    open class AuthResponse :
        Responses<ResponseData.UserData.UserResponse>(data = ResponseData.UserData.UserResponse())

}