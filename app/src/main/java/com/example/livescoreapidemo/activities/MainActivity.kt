package com.example.livescoreapidemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.fragments.LiveMatchFragment
import com.example.livescoreapidemo.fragments.NewsFragment
import com.example.livescoreapidemo.fragments.TodayMatchFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var naviView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = main_drawerLayout
        naviView = navigationView

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.layout_mainActivity, LiveMatchFragment()).commit()
            title = "Live"
        }

        naviView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_live -> {
                    replaceFragments(LiveMatchFragment(), it.title.toString())
                }
                R.id.menu_today -> {
                    replaceFragments(TodayMatchFragment(), it.title.toString())
                }
                R.id.menu_news -> {
                    replaceFragments(NewsFragment(), it.title.toString())
                }
                else -> {
                    true
                }
            }
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragments(fragment: Fragment, title: String): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.layout_mainActivity, fragment).addToBackStack(null).commit()
        drawerLayout.closeDrawers()
        setTitle(title)
        return true
    }

}