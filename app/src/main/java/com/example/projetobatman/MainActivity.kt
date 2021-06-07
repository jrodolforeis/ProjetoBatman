package com.example.projetobatman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.projetobatman.databinding.ActivityMainBinding

/**
 * Activity principal do programa
 * Aqui declaramos a existência/inicialização de alguns itens
 * drawerLayout tem suas propriedades definidas e é inserido como propriedade do appBarConfiguration
 * appBarConfiguration, por sua vez, permite a definição de algumas páginas como "principais, de maior nível hierárquico", habilitando o ícone do hamburger menu nessas páginas
 * A função onSupportNavigateUp providencia a funcionalidade do hamburger menu nas páginas principais e o botão de voltar nas secundárias, após o setup do NavigationUI.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        val navController = this.findNavController(R.id.myNavHostFragment)

        val topLevelDestinations = setOf(R.id.viloesFragment, R.id.titleFragment, R.id.filmesFragment)
        appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations)
                .setOpenableLayout(drawerLayout)
                .build()

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        NavigationUI.setupWithNavController(binding.navView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}