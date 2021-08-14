package com.example.domain.exts

import androidx.lifecycle.MutableLiveData
import com.example.data.cache.AppPref.token
import com.example.data.repository.AuthRepository
//import com.example.data.repository.AuthRepository
import com.example.domain.states.DataResponseError
import com.example.domain.states.DataStates
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.net.HttpURLConnection
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

private val refreshTokenSource = io.reactivex.Observable.create<Boolean> { emitter ->
    if (token.isEmpty())
        emitter.onComplete()
    else
        AuthRepository().refreshToken()
            .doOnError {
                emitter.onError(it)
            }
            .map {
                it.data?.let {
                    token = it.token
                    emitter.onNext(true)
                    emitter.onComplete()
                } ?: run {
                    emitter.onError(Throwable("token not retrieved"))
                }

            }.subscribe()
}


fun Throwable.isAuthError(): Boolean {
    if (this is HttpException)
        return this.message() == "Unauthorized" || this.code() == HttpURLConnection.HTTP_UNAUTHORIZED
    return false
}


fun <T> io.reactivex.Observable<T>.retryAuth(): Observable<T> {

    return retryWhen { error ->
        val counter = AtomicInteger()
        error.flatMap { err ->
            if (counter.incrementAndGet() <= 1 && err.isAuthError()) {
              //  return@flatMap refreshTokenSource
            }

            return@flatMap io.reactivex.Observable.error<T>(err)
        }
    }
}


fun <T> io.reactivex.Flowable<T>.retryAuth(): Flowable<T> {

    return retryWhen { error ->
        val counter = AtomicInteger()
        error.flatMap { err ->
            if (counter.incrementAndGet() <= 1 && err.isAuthError()) {
              //  return@flatMap refreshTokenSource.toFlowable(BackpressureStrategy.LATEST)
            }

            return@flatMap io.reactivex.Flowable.error<T>(err)
        }
    }

}

