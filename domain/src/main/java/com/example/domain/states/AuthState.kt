package com.example.domain.states

data class authFailure(var message: String = "unable to authenticate user") : PasswordResetStates()
object authSuccess : PasswordResetStates()
object userSignUpComplete : PasswordResetStates()