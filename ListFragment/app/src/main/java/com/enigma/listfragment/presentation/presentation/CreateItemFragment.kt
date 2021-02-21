package com.enigma.listfragment.presentation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.enigma.listfragment.R
import com.enigma.listfragment.presentation.utils.Item
import kotlinx.android.synthetic.main.card_view.*
import kotlinx.android.synthetic.main.fragment_create_item.*

class CreateItemFragment(private val onNavigationListener: OnNavigationListener) : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnAdd.setOnClickListener {
            val item = Item(
                date = input_date.text.toString(),
                itemName = item_name.text.toString(),
                quantity = quantity.text.toString().toInt(),
                note = notes_input.text.toString()
            )
            if (item != null) {
                onNavigationListener.addItem(item)
                Toast.makeText(
                    activity,
                    "Item: ${item.itemName} has been added",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
 @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) =
     CreateItemFragment(onNavigationListener)
    }
}