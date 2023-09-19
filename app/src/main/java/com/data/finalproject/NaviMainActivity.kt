package com.data.finalproject

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.data.finalproject.databinding.ActivityNaviMainBinding
import com.data.finalproject.navigationFragment.AboutFragment
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class NaviMainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private lateinit var binding: ActivityNaviMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var user: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = FirebaseAuth.getInstance()

        drawerLayout = findViewById(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            navigationView.setCheckedItem(R.id.nav_home)
        }


    }


    private fun replaceFragment(fragment: Fragment ){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> replaceFragment(HomeFragment())
            R.id.nav_about -> replaceFragment(AboutFragment())
            R.id.nav_logout -> {
                user.signOut()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "logout!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}


