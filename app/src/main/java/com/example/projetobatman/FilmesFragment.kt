package com.example.projetobatman

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.projetobatman.databinding.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * Classe responsável pelo comportamento do fragment_filmes
 * Note que cada botão possui um comportamento único, sendo explicitado na função onCreateView (ações geradas pelo navigation)
 */
class FilmesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentFilmesBinding>(inflater,
                R.layout.fragment_filmes,container,false)

        binding.beginsButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_filmesFragment_to_beginsFragment)
        }
        binding.risesButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_filmesFragment_to_risesFragment)
        }
        binding.knightButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_filmesFragment_to_knightFragment)
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