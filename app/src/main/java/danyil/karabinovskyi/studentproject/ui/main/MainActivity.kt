package danyil.karabinovskyi.studentproject.ui.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseBindingActivity
import danyil.karabinovskyi.studentproject.databinding.ActivityMainBinding
import danyil.karabinovskyi.studentproject.utils.gone
import danyil.karabinovskyi.studentproject.utils.visible

@AndroidEntryPoint
class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override val layoutId = R.layout.activity_main
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var newNavController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.main_nav_host_container
        ) as NavHostFragment
        navController = navHostFragment.navController
        // Setup the bottom navigation view with navController
        val bottomNavigationView = binding.bottomNavView


        // Setup the ActionBar with navController and 3 top level destinations
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.primaryFragment, R.id.primaryFragment2,  R.id.primaryFragment3,R.id.primaryFragment5,R.id.loginFragment2)
        )
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
            navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.primaryFragment -> {
                    val newNavHostFragment = supportFragmentManager.findFragmentById(
                        R.id.main_nav_host_container
                    ) as NavHostFragment
                    navController = newNavHostFragment.navController
                    bottomNavigationView.setupWithNavController(navController)
                    findViewById<Toolbar>(R.id.toolbar).visible()
                    findViewById<BottomNavigationView>(R.id.bottom_nav_view).visible()
                }
                R.id.registrationFragment -> {

//                    findViewById<Toolbar>(R.id.toolbar).gone()
                }
                else -> {
//                    findViewById<Toolbar>(R.id.toolbar).visible()
                }
            }
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}