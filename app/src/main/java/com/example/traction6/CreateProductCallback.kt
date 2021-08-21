package com.example.traction6

import com.example.traction6.factory.UIFactoryAdapter

interface CreateProductCallback {
    fun onSaveProductItem(factoryAdapter: UIFactoryAdapter)
    fun onStockChangeComplete(factoryAdapter: UIFactoryAdapter)
}