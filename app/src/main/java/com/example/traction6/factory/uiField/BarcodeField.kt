package com.example.traction6.factory.uiField

import android.content.Context
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
    UIField(R.layout.recyclerview_row) {


     override fun getValue(): Any {
        return text
    }

    override fun hasValidData(): Boolean {
        return true
    }


    override fun bind(itemView: View, factoryEventListener: FactoryEventListener?) {
        itemView.tvcode.setText(text)
        itemView.tvcode.addTextChangedListener(object : TextWatcherAdapter() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                super.onTextChanged(s, start, before, count)
                s?.let {
                    text = it.toString()
                }
            }
        })

       /*itemView.fab_create.setOnClickListener {
            factoryEventListener?.onItemClicked(this)
        }*/

    }
}
