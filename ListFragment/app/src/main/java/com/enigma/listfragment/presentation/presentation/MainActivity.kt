package com.enigma.listfragment.presentation.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.enigma.listfragment.R
import com.enigma.listfragment.presentation.utils.Item
import com.enigma.listfragment.presentation.utils.ItemList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener , OnNavigationListener {

    private lateinit var createItemFragment: CreateItemFragment
    private lateinit var viewListFragment: ViewListFragment

//    private lateinit var imageFragment: ImageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewListFragment = ViewListFragment.newInstance(this)
        switchFragment(viewListFragment)
        createItemFragment = CreateItemFragment.newInstance(this)
        switchFragment(createItemFragment)


        create_item.setOnClickListener(this)
        view_list.setOnClickListener(this)


//        supportFragmentManager.beginTransaction().add(
//            R.id.fragmentContainer, imageFragment
//        ).commit()
    }

    private fun switchFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    override fun onClick(view : View?) {
        when(view) {
            create_item -> {
                switchFragment(createItemFragment)
            }
            view_list -> {
                switchFragment(viewListFragment)
            }
        }
    }

    override fun createItem() {
        createItemFragment = CreateItemFragment.newInstance(this)
        switchFragment(createItemFragment)
    }

    override fun showListItems() {
        viewListFragment = ViewListFragment.newInstance(this)
        switchFragment(viewListFragment)
    }

    override fun addItem(item: Item) {
        ItemList.add(item)
    }
}