package com.yuwol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kakao.sdk.user.UserApiClient
import com.yuwol.databinding.ActivityMainBinding
import com.yuwol.fragment.*
import kotlinx.android.synthetic.main.fragment_third_rating.*

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

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