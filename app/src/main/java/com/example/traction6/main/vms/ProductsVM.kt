package com.example.traction6.main.vms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.states.DataStates
import com.example.traction6.factory.UIFactoryAdapter
import com.example.traction6.factory.uiField.BarcodeField
import com.example.traction6.factory.uiField.UIField
import com.example.traction6.pageFactory.ProductFactory
import io.reactivex.disposables.CompositeDisposable

class ProductsVM :ViewModel() {

    val productBarcode = MutableLiveData<DataStates>()
    private val compositeDisposable = CompositeDisposable()
val uiFields : LiveData<MutableList<UIField>> = MutableLiveData()

    // val barcodeField = itemFactoryAdapter.fieldWithKey(ProductFactory.Keys.BarcodeKey)


    fun updateBarcodeField(factoryAdapter: UIFactoryAdapter, barcode: String) {
        (factoryAdapter.fieldWithKey(ProductFactory.Keys.BarcodeKey) as? BarcodeField)?.let {
            val index = factoryAdapter.fieldIndex(it)
            if (index != -1) {
                it.text = barcode
                factoryAdapter.notifyItemChanged(index)

            }
        }
    }


}