package com.example.data.exts

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> io.reactivex.Observable<T>.standard(liveObj: MutableLiveData<T>? = null): Observable<T> {

    return this
        .doOnError {}
        .onErrorResumeNext(io.reactivex.Observable.empty())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


}


fun <T> io.reactivex.Flowable<T>.standard(liveObj: MutableLiveData<String>? = null):  io.reactivex.Flowable<T> {

    return this
        .doOnError {}
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> io.reactivex.Maybe<T>.standard(liveObj: MutableLiveData<T>? = null):  io.reactivex.Maybe<T> {

    return this
        .doOnError {}
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun  io.reactivex.Completable.standard():  io.reactivex.Completable {

    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}


