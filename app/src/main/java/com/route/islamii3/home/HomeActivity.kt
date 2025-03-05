package com.route.islamii3.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islamii3.R

import com.route.islamii3.databinding.ActivityHomeBinding
import com.route.islamii3.home.fragments.hadith.HadithFragment
import com.route.islamii3.home.fragments.quran.QuranFragment
import com.route.islamii3.home.fragments.radio.RadioFragment
import com.route.islamii3.home.fragments.tasbeeh.TasbeehFragment

class HomeActivity : AppCompatActivity() {
        lateinit var homeBinding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
/**    Das heißt Nested Binding         */
        homeBinding.includedContentHome
            .navigationMenu.setOnItemSelectedListener {
                when(it.itemId){
                    /**Hier können wir beide Methode,nicht nur die eine mit {}
                       und auch, sondern auch die andere mit keinen {}, benutzen*/
                    R.id.navigation_quran -> { showFragment(QuranFragment()) }
                    R.id.navigation_hadith -> showFragment(HadithFragment())
                    R.id.navigation_tasbeeh -> showFragment(TasbeehFragment())
                    R.id.navigation_radio -> showFragment(RadioFragment())
                }

            return@setOnItemSelectedListener true
        }

        homeBinding.includedContentHome.navigationMenu.selectedItemId =
            R.id.navigation_quran

/*        contentHomeBinding = ContentHomeBinding.inflate(layoutInflater)

        contentHomeBinding.navigationMenu

       val navigationMenu = homeBinding.root.findViewById<BottomNavigationView>(R.id.navigation_menu)

 */
    }

    private fun showFragment(fragment: Fragment ) {
        supportFragmentManager.beginTransaction()
            .replace(homeBinding.includedContentHome.fragmentContainer.id,fragment)
            .commit()
    }

}