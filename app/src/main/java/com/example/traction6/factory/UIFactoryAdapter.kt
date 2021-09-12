package com.example.traction6.factory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.Entities.BarcodeUsers
import com.example.traction6.R
import kotlinx.android.synthetic.main.recyclerview_row.view.*


open class UIFactoryAdapter( var context: Context, var items: List<BarcodeUsers>) : RecyclerView.Adapter<UIFactoryAdapter.MyViewHolder>(){

   /* fun setListData(data: ArrayList<BarcodeUsers>) {
        this.items = data
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row,parent, false)

        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rowItem = items[position]

        holder.tvBarcode.text = rowItem.barcode_result

      //  holder.bind(items[position])
    }


    class MyViewHolder(itemsView: View?): RecyclerView.ViewHolder(itemsView!!){

        val tvBarcode = itemsView!!.tvcode

      /*  fun bind(code: String){
            tvBarcode.text = code.toString()

        }*/
    }
}








