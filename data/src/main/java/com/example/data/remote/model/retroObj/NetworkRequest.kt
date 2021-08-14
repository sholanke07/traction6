package com.example.data.remote.model.retroObj

sealed class NetworkRequest {
    data class Login(var email: String = "", val password: String = "")

    data class RefreshToken(val token: String)
}