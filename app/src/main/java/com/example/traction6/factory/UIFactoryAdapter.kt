package com.example.traction6.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.traction6.R
import kotlinx.android.synthetic.main.recyclerview_row.view.*


open class UIFactoryAdapter(private var items: ArrayList<String>) : RecyclerView.Adapter<UIFactoryAdapter.MyViewHolder>(){
//open class UIFactoryAdapter(private var uiModels: MutableList<UIField>): RecyclerView.Adapter<UIFactoryAdapter.MyViewHolder>(){


    fun setListData(data: ArrayList<String>) {
        this.items = data
    }
   //private var items = ArrayList<String>()
       // this.items = data
      // this.uiModels = data
    //var items = ArrayList<String>

   // }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row,parent, false)

        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position] )
    }


    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        val tvBarcode = view.tvcode

        fun bind(code: String){
            tvBarcode.text = code

        }
    }
}
/*open class UIFactoryAdapter(
        private val uiModels: MutableList<UIField>,
        private var factoryEventListener: FactoryEventListener? = null,
) : RecyclerView.Adapter<UIFactoryViewHolder>() {


    private var onBind: Boolean = false

    private val uiModelsData: MutableList<UIField> = arrayListOf()

    override fun getItemViewType(position: Int): Int {
        return uiModels[position].layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UIFactoryViewHolder {
        return UIFactoryViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
    }

    override fun getItemCount(): Int {
        return uiModels.size
    }

    override fun onBindViewHolder(holder: UIFactoryViewHolder, position: Int) {
        onBind = true
        holder.bind(uiModels[position], factoryEventListener)
        onBind = false
    }

    fun isOnBind(): Boolean {
        return onBind
    }

    fun setEventAdapter(factoryEventListener: FactoryEventListener) {
        this.factoryEventListener = factoryEventListener
    }

    fun updateProduct(uiModels: MutableList<UIField>) {
        this.uiModelsData.clear()
        this.uiModels.clear()
        this.uiModelsData.addAll(uiModels)
        this.uiModels.addAll(uiModels)
        notifyDataSetChanged()
    }

    fun addToList(newUiModels: MutableList<UIField>, currentPage: Int) {
        if (currentPage <= 1) {
            this.uiModelsData.clear()
            this.uiModels.clear()
            this.uiModelsData.addAll(newUiModels)
            this.uiModels.addAll(newUiModels)
            notifyDataSetChanged()
        } else {
            val initPosition = uiModels.size
            uiModels.addAll(newUiModels)
            uiModelsData.clear()
            uiModelsData.addAll(uiModels)
            notifyItemRangeInserted(initPosition, uiModels.size)
        }
    }

    fun items(): MutableList<UIField> {
        return uiModels
    }

    fun fieldWithKey(key: String): UIField? {
        return uiModels.find { it.key == key }
    }

    fun fieldIndex(field: UIField): Int {
        return uiModels.indexOfFirst { field.key == it.key }
    }

    fun fieldIndexWithKey(key: String): Int {
        val field = uiModels.find { it.key == key }
        return field?.let { uiModels.indexOf(field) } ?: kotlin.run { -1 }
    }

    fun isFormValid(): Boolean {
        var result = true
        uiModels.forEach {
            result = result && it.hasValidData()
        }
        return result
    }


    fun formWarning(): String {
        uiModels.forEach {
            if (!it.hasValidData())
                return it.errorMessage
        }
        return ""
    }

    fun factoryFormData(): HashMap<String, Any> {
        val data = hashMapOf<String, Any>()
        uiModels.forEach {
            data[it.myKey()] = it.getValue()
        }
        return data
    }
}*/


