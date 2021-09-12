package com.example.traction6.Onboarding.auth.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

  val message = MutableLiveData<String>()

  fun sendMessage(text: String, new: String) {
    message.value = text
    message.value = new
  }

  // Mutable LiveData which observed by LiveData
  // and updated to EditTexts when it is changed.
 /* private val mutableLiveData: MutableLiveData<String> = MutableLiveData()

    // function to set the changed
    // data from the EditTexts
    fun setData(input: String) {
        mutableLiveData.value = input
    }

    // function to get the changed data from the EditTexts
    fun getData(): MutableLiveData<String> = mutableLiveData*/



  /*  val message = MutableLiveData<String>()

    fun setMsgCommunicator(msg: String){
        message.setValue(msg)
    }*/
}