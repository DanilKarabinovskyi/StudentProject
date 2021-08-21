package danyil.karabinovskyi.studentproject.ui.global

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseBindingActivity
import danyil.karabinovskyi.studentproject.databinding.ActivityGlobalBinding
import danyil.karabinovskyi.studentproject.utils.gone
import danyil.karabinovskyi.studentproject.utils.visible

@AndroidEntryPoint
class GlobalActivity : BaseBindingActivity<ActivityGlobalBinding>() {

    override val layoutId = R.layout.activity_global
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.global_nav_host_container
        ) as NavHostFragment
        navController = navHostFragment.navController
        // Setup the bottom navigation view with navController

        bottomNavigationView = binding.bottomNavView
        bottomNavigationView.setupWithNavController(navController)

        // Setup the ActionBar with navController and 3 top level destinations
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.primaryFragment, R.id.primaryFragment2, R.id.primaryFragment3,
                R.id.primaryFragment5,
                R.id.loginFragment2
            )
        )
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.primaryFragment -> {

                    toolbar.gone()
                    bottomNavigationView.visible()
                    bottomNavigationView.selectedItemId = R.id.nav_graph_primary_item
                }
                R.id.loginFragment3 -> {
                    toolbar.visible()
                }
                else -> {
                    toolbar.visible()
                }
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}