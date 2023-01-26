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
        var bundle = Bundle()
        
        val token = intent.getStringExtra("token")!!
        bundle.putString("token", token)

        var name = intent.getStringExtra("name")
        if (name == null) {
            name = "유월"
        }
        var image_uri = intent.getStringExtra("image")
        if (image_uri == null) {
            image_uri = R.drawable.profile_default.toString()
        }
        var introduce = intent.getStringExtra("introduce")
        if (introduce == null) {
            introduce = "안녕하세요 팀 유월입니다!"
        }
        bundle.putString("name", name)
        bundle.putString("image", image_uri)
        bundle.putString("introduce", introduce)

        fragment.arguments = bundle

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_main, fragment)
        fragmentTransaction.commit()
    }
}