package com.example.traction6.factory.`interface`

import com.example.traction6.factory.uiField.UIField

interface FactoryEventListener {
    fun onActionFieldClicked(uiFieldKey: String, checked: Boolean)
    fun onItemClicked(uiField: UIField, params: Any = Any())
}