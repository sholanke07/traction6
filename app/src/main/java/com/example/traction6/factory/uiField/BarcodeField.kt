package com.example.traction6.factory.uiField

import android.view.View
import androidx.fragment.app.Fragment
import com.example.traction6.R
import com.example.traction6.factory.TextWatcherAdapter
import com.example.traction6.factory.`interface`.FactoryEventListener
import kotlinx.android.synthetic.main.fab.view.*
import kotlinx.android.synthetic.main.fragment_item_barcode.view.*
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class BarcodeField (
    var hint: String = "",
    var text: String = ""
    ) :
    UIField(R.layout.fragment_recyclerview) {

    override fun getValue(): Any {
        return text
    }

    override fun hasValidData(): Boolean {
        return true
    }


    override fun bind(itemView: View, factoryEventListener: FactoryEventListener?) {
        // itemView.testTV2.hint = hint
        itemView.testTV2.setText(text)
        itemView.testTV2.addTextChangedListener(object : TextWatcherAdapter() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                super.onTextChanged(s, start, before, count)
                s?.let {
                    text = it.toString()
                }
            }
        })

        itemView.fab_create.setOnClickListener {
            factoryEventListener?.onItemClicked(this)
        }

    }
}
