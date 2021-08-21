package com.example.traction6.factory.uiField

import android.view.View
import com.example.traction6.factory.`interface`.FactoryEventListener

abstract class UIField (
    val layout: Int,
    var key: String = "",
    var errorMessage: String = "",
    val code: String = "",
    var dataSource: Any = Any()
    ) {


        fun withKey(key: String): UIField {
            this.key = key
            return this
        }

        fun withDataSource(dataSource: Any): UIField {
            this.dataSource = dataSource
            return this
        }


        open fun errorMessage(message: String): UIField {
            this.errorMessage = message
            return this
        }


        fun myKey(): String {
            return key
        }

        fun warn(): String {
            return errorMessage
        }

        open fun getValue(): Any {
            return Any()
        }

        override fun equals(other: Any?): Boolean {
            return (other as? UIField)?.key?.equals(this.key) ?: kotlin.run { false }
        }

        override fun hashCode(): Int {
            return key.hashCode()
        }

        abstract fun bind(itemView: View, factoryEventListener: FactoryEventListener?)

        abstract fun hasValidData(): Boolean

    }