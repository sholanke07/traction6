package com.example.traction6.factory

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.traction6.factory.`interface`.FactoryEventListener
import com.example.traction6.factory.uiField.UIField

open class UIFactoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(uiModel: UIField, factoryEventListener: FactoryEventListener?) {
        uiModel.bind(itemView,factoryEventListener)
    }

}