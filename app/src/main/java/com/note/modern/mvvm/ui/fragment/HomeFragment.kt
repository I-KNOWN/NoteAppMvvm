package com.note.modern.mvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
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
                menuInflater.inflate(R.menu.toolbar_menu, menu)

                if(menu.findItem(R.id.search_notes) == null){
                    var menuItem = menu.findItem(R.id.search_notes)
                    var searchView = menuItem.actionView as SearchView

//                    menuItem.icon = ContextCompat.getDrawable(requireContext(), R.drawable.app_logo)


//                    menuItem.icon = ContextCompat.getDrawable(requireActivity(), R.drawable.search_ic)
/*                    menuItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener{
                        override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                            TODO("Not yet implemented")
                        }

                        override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                            TODO("Not yet implemented")
                        }

                    })*/
                }

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                /*when(menuItem.itemId){
                    R.id.search_notes->
                }*/
                return false
            }

        }
        menuHost.addMenuProvider(menuProvider, viewLifecycleOwner)

    }




}