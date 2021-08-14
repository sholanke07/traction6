package com.example.domain.Implementations


import androidx.lifecycle.Transformations.map
import com.example.data.cache.AppPref.businessCreated
import com.example.data.cache.AppPref.businessId
import com.example.data.cache.AppPref.token
import com.example.data.remote.model.retroObj.NetworkRequest
import com.example.data.repository.AuthRepository
//import com.example.data.repository.AuthRepository
import com.example.data.repository.BusinessRepository
import com.example.domain.states.DataStates
import com.example.domain.states.authFailure
import com.example.domain.states.authSuccess
import com.example.domain.useCases.AuthUsecase
import io.reactivex.Observable

open class AuthUsecaseImpl(
        private val userRepo: AuthRepository = AuthRepository()

): AuthUsecase {

    override fun signInUser(email: String, password: String): Observable<DataStates> {


       // return userRepo.clearAllUserData().andThen(

               return userRepo.auth(NetworkRequest.Login(email, password))
                        .map { auth ->
                            if (auth.status) {
                                token = auth.data?.token ?: kotlin.run { "" }
                                authSuccess
                            } else {
                                authFailure(auth.message)
                            }

                        }
    }
}




















