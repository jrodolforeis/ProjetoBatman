package com.example.projetobatman

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.projetobatman.databinding.FragmentBruceBinding
import com.example.projetobatman.databinding.FragmentSymbolBinding
import com.example.projetobatman.databinding.FragmentTitleBinding
import com.example.projetobatman.databinding.FragmentViloesBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ViloesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentViloesBinding>(inflater,
                R.layout.fragment_viloes,container,false)

        binding.jokerButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_viloesFragment_to_jokerFragment)
        }
        binding.baneButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_viloesFragment_to_baneFragment)
        }
        binding.harveyButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_viloesFragment_to_harveyFragment)
        }
        binding.rasButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_viloesFragment_to_rasFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }

}