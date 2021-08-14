package com.example.domain.exts

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlin.reflect.KFunction1

fun Context.message(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

inline fun <reified T : ViewModel> Fragment.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
}

inline fun <reified T : ViewModel> Fragment.withViewModel(
    viewModelFactory: ViewModelProvider.Factory,
    body: T.() -> Unit
): T {
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}

/*fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: KFunction1<String, Unit>) {

 Log.d("femi","livedata");
    liveData.observe(this, Observer(body))
}*/
fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}
fun View.show() {
    visibility = View.VISIBLE
}