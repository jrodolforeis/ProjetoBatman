package com.example.projetobatman

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.projetobatman.databinding.FragmentBruceBinding
import com.example.projetobatman.databinding.FragmentTitleBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BruceFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBruceBinding>(inflater,
            R.layout.fragment_bruce,container,false)

        binding.nextButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_bruceFragment_to_titleFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }
/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,view!!.findNavController())
                ||super.onOptionsItemSelected(item)
    }
*/
}