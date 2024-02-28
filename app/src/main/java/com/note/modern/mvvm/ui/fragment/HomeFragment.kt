package com.note.modern.mvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.google.android.material.search.SearchBar
import com.note.modern.mvvm.R
import com.note.modern.mvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var menuProvider: MenuProvider
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        initSearch()

        return binding.root
    }

    private fun initSearch() {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Notes"

        val menuHost = requireActivity()
        menuProvider = object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

                if(menu.findItem(R.id.search_notes) == null){
                    menuInflater.inflate(R.menu.toolbar_menu, menu)
                    var menuItem = menu.findItem(R.id.search_notes)
                    var searchBar = menuItem.actionView as SearchBar;
                    menuItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener{
                        override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                            TODO("Not yet implemented")
                        }

                        override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                            TODO("Not yet implemented")
                        }

                    })
                }

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                TODO("Not yet implemented")
            }

        }
        menuHost.addMenuProvider(menuProvider)

    }


}