package com.programmer.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Isi content*/
        val fragment = HomeFragment.newInstance("test1","test2")
        bottom_navigation_view.setOnNavigationItemSelectedListener(menuItemSelected)
        addFragment(fragment)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.Search -> {
                Toast.makeText(this,"You Clicked Search!", Toast.LENGTH_LONG).show()
                return true
            } R.id.actHome -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.content, HomeFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            } R.id.actShorts -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.content, ShortsFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            } R.id.acSubs -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.content, SubscriptionFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            } R.id.actLibr -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.content, LibraryFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            }else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
    /*Deteksi Menu Item Yang Diklik*/
    private val menuItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.itemHome ->{
                val fragment = HomeFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemShorts ->{
                val fragment = ShortsFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemSubs ->{
                val fragment = SubscriptionFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemLibr ->{
                val fragment = LibraryFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    /*Memanggil Fragment ke frame_layout di activity_main*/
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }
}