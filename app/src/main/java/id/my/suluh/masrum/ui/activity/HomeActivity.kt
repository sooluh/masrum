package id.my.suluh.masrum.ui.activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import id.my.suluh.masrum.R
import id.my.suluh.masrum.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dataset,
                R.id.navigation_feature,
                R.id.navigation_model,
                R.id.navigation_play,
            )
        )

        navView.setupWithNavController(navController)
    }

}
