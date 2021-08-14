package com.example.domain.useCases

import com.example.domain.states.DataStates
import io.reactivex.Observable

open interface
AuthUsecase {
    fun signInUser(email: String, password: String): Observable<DataStates>
}