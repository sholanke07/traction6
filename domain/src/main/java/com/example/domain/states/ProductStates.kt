package com.example.domain.states

object ProductCreated : ProductStates()
data class CountCreated(var data: String?) : ProductStates()
object CountUpdated : ProductStates()
object ProductDeleted : ProductStates()
//data class ProductLoaded(var data: MutableList<TractionProducts>) : ProductStates()
data class BarcodeGenerated(var data: String?) : ProductStates()
object ProductUpdated : ProductStates()
object FailedNoBusiness : ProductStates()
