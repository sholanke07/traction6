package com.example.domain.useCases

import com.example.data.remote.model.retroObj.NetworkRequest
import com.example.domain.states.DataStates
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import okhttp3.MultipartBody

interface ProductUsecase {

    fun productsByBusiness(businessId: String): Flowable<DataStates>
    fun productsByTimeStamp(businessId: String): Flowable<DataStates>
    fun pagedLocalProducts(productName: String, limit: Int, offset: Int): Flowable<DataStates>
    fun allPagedProducts(businessId: String, productName: String, limit: Int, offset: Int): Flowable<DataStates>
    fun createBarcode(businessId: String): Observable<DataStates>
    fun barcodeList(barcodeUser: String): Observable<DataStates>
    fun deleteStockCount(countId: String)
    fun deleteTempVariant()

    fun createOrUpdateProduct(

            barcode: String,
            updateReason: String?,
            updateVariant: String?
    ): Observable<DataStates>

}