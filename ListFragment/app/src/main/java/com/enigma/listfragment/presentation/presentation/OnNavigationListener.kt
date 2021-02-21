package com.enigma.listfragment.presentation.presentation

import com.enigma.listfragment.presentation.utils.Item

interface OnNavigationListener {
    fun createItem()
    fun showListItems()
    fun addItem(item: Item)
}