package com.example.traction6.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.Entities.BarcodeUsers
import com.example.traction6.R
import kotlinx.android.synthetic.main.new_row.view.*
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class Adapter(var item : ArrayList<String>):RecyclerView.Adapter<Adapter.MyViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.new_row,parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {
        holder.bind(item[position])
    }


    override fun getItemCount(): Int {
        return item.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tv = view.row

        fun bind(data: String){
            tv.text = data

        }

    }
}