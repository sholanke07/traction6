package com.example.traction6.exts

import androidx.lifecycle.MutableLiveData
import com.example.domain.states.DataResponseError
import com.example.domain.states.DataStates
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*

fun <T> io.reactivex.Observable<T>.standard(liveObj: MutableLiveData<DataStates>? = null): Observable<T> {

    return this
        .doOnError {
            liveObj?.postValue(DataResponseError(it))
        }
        .onErrorResumeNext(io.reactivex.Observable.empty())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


}


fun <T> io.reactivex.Flowable<T>.standard(liveObj: MutableLiveData<DataStates>? = null):  io.reactivex.Flowable<T> {

    return this
        .doOnError {
            liveObj?.postValue(DataResponseError(it))
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


}

fun <T> io.reactivex.Maybe<T>.standard(liveObj: MutableLiveData<DataStates>? = null):  io.reactivex.Maybe<T> {

    return this
        .doOnError {
            liveObj?.postValue(DataResponseError(it))
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


}


fun  io.reactivex.Completable.standard():  io.reactivex.Completable {

    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


}


/*fun <T> io.reactivex.Observable<T>.run(liveObj: MutableLiveData<DataStates>? = null): Disposable {
    return this.retryAuth()
        .standard(liveObj)
        .subscribe()


}*/





