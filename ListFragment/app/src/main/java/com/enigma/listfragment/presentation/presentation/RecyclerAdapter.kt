package com.enigma.listfragment.presentation.presentation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enigma.listfragment.R
import com.enigma.listfragment.presentation.utils.ItemList
import kotlinx.android.synthetic.main.fragment_create_item.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var itemDate : TextView
        var itemName: TextView
        var itemQuantity: TextView
        var itemNote: TextView

        init {
            itemDate = itemView.findViewById(R.id.card_date)
            itemName = itemView.findViewById(R.id.name)
            itemQuantity = itemView.findViewById(R.id.qty)
            itemNote = itemView.findViewById(R.id.note)

            itemView.setOnClickListener{
                var position: Int = adapterPosition
                val context = itemView.context
                val intent = Intent(context, ViewListFragment::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("DATE", itemDate.text)
                    putExtra("CODE", itemName.text)
                    putExtra("CATEGORY", itemQuantity.text)
                    putExtra("CONTENT", itemNote.text)
                }
                context.startActivity(intent)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = ItemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemDate.text = ItemList[position].date
        holder.itemName.text = ItemList[position].itemName
        holder.itemQuantity.text = ItemList[position].quantity.toString()
        holder.itemNote.text = ItemList[position].note
    }
}