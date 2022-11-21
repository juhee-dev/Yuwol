package com.yuwol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.yuwol.databinding.ActivityMainBinding
import com.yuwol.fragment.HomeFragment
import com.yuwol.fragment.RatingFragment
import com.yuwol.fragment.SearchFragment
import com.yuwol.fragment.UserFragment

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.navBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.rating -> replaceFragment(RatingFragment())
                R.id.user -> replaceFragment(UserFragment())

                else -> {

                }
            }
            true
        }

    }

    private  fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_main, fragment)
        fragmentTransaction.commit()
    }
}